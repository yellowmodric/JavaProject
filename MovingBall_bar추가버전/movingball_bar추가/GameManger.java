package movingball;
import java.awt.*;

import javax.swing.SwingUtilities;

public class GameManger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SwingUtilities.invokeLater(() -> {
		    // GUI 초기화 및 실행 코드
			Box box = new Box(600);
			
			MovingBar bar = new MovingBar(250, 500, box);
			MovingBall ball = new MovingBall(300, 400, 11, box, bar);
			
			BallWriter ballwriter = new BallWriter(ball, Color.blue);
			BoxWriter boxwriter = new BoxWriter(box);
			BarWriter barwriter = new BarWriter(bar, Color.blue);
			BrickWriter brickwriter = new BrickWriter(brick, Color.blue);
			AnimationWriter aniwriter = new AnimationWriter(boxwriter,ballwriter,barwriter, 600);
			GameController move = new GameController(ball, aniwriter, bar);
			
			Thread bounceball = new Thread(() -> {
                move.runAnimation();
            });
			
			bounceball.start();
			
		});
		
		
	}

}
