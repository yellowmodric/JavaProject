package movingball;

import java.awt.Rectangle;

public class MovingBar extends Model {
	private int x_speed = 25;
	private Box box;

	public MovingBar(int x_initial, int y_initial, Box _box) {
		x_pos = x_initial;
		y_pos = y_initial;
		width = 80;
		height = 10;
		box = _box;
	}

	public void resetPosition(int x_initial, int y_initial) {
		x_pos = x_initial;
		y_pos = y_initial;
	}

	public Rectangle barRect() {
		Rectangle barRect = new Rectangle(x_pos, y_pos, width, height);
		return barRect;
	}

	public boolean isBounced(MovingBall ball) {
		return barRect().intersects(ball.ballRect());
	}

	public void moveLeft() {
		x_pos -= x_speed;
		if (box.barContact(barRect()))
			x_pos = 0;
	}

	public void moveRight() {
		x_pos += x_speed;
		if (box.barContact(barRect()))
			x_pos = box.widthOf() - width;
	}

	public void setSpeed(int speed) {
		x_speed = speed;
	}

	public void setBar(int width) {
		this.width = width;
	}

}
