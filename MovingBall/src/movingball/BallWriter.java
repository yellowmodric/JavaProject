package movingball;
import java.awt.*;

public class BallWriter {
	private MovingBall ball;
	private Color balls_color;
	
	public BallWriter(MovingBall x, Color c) {
		ball = x;
		balls_color = c;
	}
	
	public void paint(Graphics g) {
		g.setColor(balls_color);
		int radius = ball.radiusOf();
		g.fillOval(ball.xPosition(), ball.yPosition(), radius * 2, radius * 2);
	}
}



