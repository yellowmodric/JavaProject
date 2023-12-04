package movingball;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GameController extends JPanel implements KeyListener {
	private MovingBall ball;
	private AnimationWriter writer;
	private MovingBar bar;
	private int time_unit = 1;
	
	
	public GameController(MovingBall b, AnimationWriter w, MovingBar r) {
		ball = b;
		writer = w;
		bar = r;
		writer.addKeyListener(this);
		writer.setFocusable(true);
	}
	
	private void initializeBricks() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                int brickX = 60 + i * 60;
                int brickY = 60 + j * 15;
                bricks.add(new Brick(brickX, brickY));
            }
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
            	bar.moveLeft(time_unit);
            	writer.repaint();
                break;
            case KeyEvent.VK_RIGHT:
                bar.moveRight(time_unit);
                writer.repaint();
                break;
        }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	
	public void runAnimation() {
		
		int painting_delay = 10;
	
		while (true) {
			delay(painting_delay);
			ball.move(time_unit);
			writer.repaint();
		}
	}
	
	private void delay(int how_long) {
		try {Thread.sleep(how_long);}
		catch (InterruptedException e) {}
	}
}
