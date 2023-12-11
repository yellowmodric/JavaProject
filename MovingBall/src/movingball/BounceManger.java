package movingball;
import java.awt.*;

public class BounceManger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box = new Box(600);
		MovingBall ball = new MovingBall(100, 100, 11, box);
		BallWriter ballwriter = new BallWriter(ball, Color.blue);
		BoxWriter boxwriter = new BoxWriter(box);
		AnimationWriter aniwriter = new AnimationWriter(boxwriter,ballwriter, 600);
		BounceController move = new BounceController(ball, aniwriter);
		move.runAnimation();
	}

}
