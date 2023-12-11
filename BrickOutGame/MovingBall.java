package movingball;

import java.awt.Rectangle;


public class MovingBall extends Model {
	private int radius;
	private int x_velocity = 5;
	private int y_velocity = 2;
	private Box box;
	private MovingBar bar;
	
	
	public MovingBall (int x_initial, int y_initial, int r, Box _box, MovingBar _bar) {
		x_pos = x_initial;
		y_pos = y_initial;
		radius = r;
		box = _box;
		bar= _bar;
	}
	
	public void resetPosition(int x_initial, int y_initial) {
        x_pos = x_initial;
        y_pos = y_initial;
    }
	
	public int radiusOf() {
		return radius;
	}
	
	public Rectangle ballRect() {
		Rectangle ballRect = new Rectangle(x_pos, y_pos, radius * 2, radius * 2);	
		return ballRect;
	}

	public void move(double time_units) {
		x_pos += x_velocity * time_units;
		if (box.wallHorContact(x_pos, radius))
			x_velocity = -x_velocity;
		y_pos += y_velocity * time_units;
		if (box.wallVerContact(y_pos, radius) || bar.isBounced(this) )				
			y_velocity = -y_velocity;
	}

	public void bounce(Brick brick) {
	    String direction = brick.getDirection(this);

	    switch (direction) {
	        case "TOP":
	        case "BOTTOM":
	            // y 방향으로 반전
	            y_velocity = -y_velocity;
	            break;
	        case "LEFT":
	        case "RIGHT":
	            // x 방향으로 반전
	            x_velocity = -x_velocity;
	            break;
	        case "NONE":
	            // 아무 처리도 필요 없음
	            break;
	    }
	}

	
	
}
