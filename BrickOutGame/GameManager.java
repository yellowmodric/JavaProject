package movingball;

import java.awt.*;
import javax.swing.SwingUtilities;
import java.awt.event.*;

public class GameManager {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			// GUI 초기화 및 실행 코드
			Box box = new Box(400, 600);

			MovingBar bar = new MovingBar(160, 500, box);
			MovingBall ball = new MovingBall(300, 200, 5, box, bar);

			BallWriter ballwriter = new BallWriter(ball, Color.white);
			BoxWriter boxwriter = new BoxWriter(box);
			BarWriter barwriter = new BarWriter(bar, Color.white);
			BrickWriter brickwriter = new BrickWriter(box, Color.white);
			AnimationWriter aniwriter = new AnimationWriter(boxwriter, ballwriter, barwriter, brickwriter, 400, 600);

			UserManage um = new UserManage();

			GameController move = new GameController(ball, aniwriter, bar, box, um);

			Thread bounceball = new Thread(() -> {
				move.runAnimation();
			});

			bounceball.start();

		});

	}

}
