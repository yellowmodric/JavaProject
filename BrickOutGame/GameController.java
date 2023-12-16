package movingball;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameController extends JPanel implements KeyListener {
	private MovingBall ball;
	private AnimationWriter writer;
	private MovingBar bar;
	private Box box;
	private double time_unit = 1;
	private UserManage um;

	public GameController(MovingBall b, AnimationWriter w, MovingBar r, Box x, UserManage u) {
		ball = b;
		writer = w;
		bar = r;
		box = x;
		um = u;

		writer.addKeyListener(this);
		writer.setFocusable(true);
		writer.requestFocusInWindow();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
			case KeyEvent.VK_LEFT:
				bar.moveLeft();
				writer.repaint();
				break;
			case KeyEvent.VK_RIGHT:
				bar.moveRight();
				writer.repaint();
				break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	private void restartGame() {
		box.resetBricks(); // 새로운 벽돌 초기화
		ball.resetPosition(300, 300);
		bar.resetPosition(160, 500);

		runAnimation();
	}

	private void endGame() {
		// 게임이 종료될 때 호출되는 메소드
		long endTime = System.currentTimeMillis() / 1000;
		um.addRankingEntry(endTime); // 현재 시간을 초 단위로 저장
		String txt = um.getTxt();
		int result = JOptionPane.showConfirmDialog(null, txt + "\n다시하기", "", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION)
			restartGame();
		else
			System.exit(0);
	}

	public void runAnimation() {

		int painting_delay = 10;

		String input = JOptionPane.showInputDialog("사용자 이름을 입력하세요.");
		if (input == null) {
			System.exit(0);
		}
		while (input.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "이름을 입력해야 합니다.");
			input = JOptionPane.showInputDialog("사용자 이름을 입력하세요.");
			if (input == null) {
				System.exit(0);
			}
		}
		
		long startTime = System.currentTimeMillis() / 1000;
		um.setUser(input, startTime);

		String[] options = { "Easy", "Normal", "Hard" };
		String difficulty = (String) JOptionPane.showInputDialog(null,
				"난이도를 선택하세요.", "Difficulty",
				JOptionPane.QUESTION_MESSAGE, null,
				options, options[0]);
		if (difficulty == null) {
			System.exit(0);
		}

		if (difficulty != null) {
			if (options[0] == difficulty) {
				setDifficulty("easy");
			} else if (options[1] == difficulty) {
				setDifficulty("normal");
			} else {
				setDifficulty("hard");
			}
		}

		while (true) {
			delay(painting_delay);
			boolean allBricksDestroyed = true;

			// 공이 바닥에 떨어졌다면
			if (ball.yPosition() + 2 * ball.radiusOf() >= box.height) {
				int result = JOptionPane.showConfirmDialog(null, "게임오버\n다시하기", "", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.out.println("사용자가 '예'를 선택했습니다.");
					restartGame();
				} else {
					System.exit(0);
				}
				break;
			}

			for (Brick brick : box.getBricks()) {
				if (!brick.isDestroyed()) {
					// 아직 파괴되지 않은 벽돌이 있다면
					allBricksDestroyed = false;

					// 벽돌과 공이 충돌했다면
					if (brick.isCollided(ball)) {
						ball.bounce(brick);
					}
				}
			}

			if (allBricksDestroyed) {
				// 모든 벽돌이 파괴되었다면 루프를 종료
				endGame();
				break;
			}

			ball.move(time_unit);
			writer.repaint();
		}
	}

	private void delay(int how_long) {
		try {
			Thread.sleep(how_long);
		} catch (InterruptedException e) {
		}
	}

	public void setDifficulty(String difficulty) {
		// 난이도에 따른 속도 조절 - 공이 움직이는 속도, 공의 크기, 막대바의 너비, 막대바가 움직이는 속도로 난이도 조절
		switch (difficulty) {
			case "easy":
				ball.setVelocity(5, 2);
				bar.setSpeed(45);
				ball.setRadius(11);
				bar.setBar(150);
				break;
			case "normal":
				ball.setVelocity(6, 3);
				bar.setSpeed(40);
				ball.setRadius(9);
				bar.setBar(120);
				break;
			case "hard":
				ball.setVelocity(6, 4);
				bar.setSpeed(35);
				ball.setRadius(7);
				bar.setBar(90);
				break;
			default:
				ball.setVelocity(5, 2);
				bar.setSpeed(45);
				ball.setRadius(11);
				bar.setBar(150);
				break;
		}
	}
}
