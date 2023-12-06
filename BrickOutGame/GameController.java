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
		um= u;
		
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
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	private void restartGame() {
        box.resetBricks(); // 새로운 벽돌 초기화
        ball.resetPosition(300, 400);
        bar.resetPosition(160, 500);
        
        runAnimation();
    }
	
	private void endGame() {
        // 게임이 종료될 때 호출되는 메소드
		long endTime = System.currentTimeMillis() / 1000;
        um.addRankingEntry(endTime); // 현재 시간을 초 단위로 저장
        String txt = um.getTxt();
        int result =JOptionPane.showConfirmDialog(null, txt+"\n다시하기", "", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION)
            restartGame();
		else
        	System.exit(0);
    }
	
	public void runAnimation() {
		
		int painting_delay = 10;
		
		String input = JOptionPane.showInputDialog("사용자 이름을 입력하세요.");
		long startTime=System.currentTimeMillis() / 1000;
		um.setUser(input, startTime);
	
		while (true) {
			delay(painting_delay);
			boolean allBricksDestroyed = true;
			
			//공이 바닥에 떨어졌다면
			if (ball.yPosition()+2*ball.radiusOf() >= box.height) {
				int result =JOptionPane.showConfirmDialog(null, "게임오버\n다시하기", "", JOptionPane.YES_NO_OPTION);
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
		            
		            //벽돌과 공이 충돌했다면
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
		try {Thread.sleep(how_long);}
		catch (InterruptedException e) {}
	}
}
