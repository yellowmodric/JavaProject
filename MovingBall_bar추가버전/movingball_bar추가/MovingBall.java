package movingball;

public class MovingBall {
	private int x_pos, y_pos, radius;
	private int x_velocity = 5;
	private int y_velocity = 2;
	private Box container;
	private MovingBar bar;
	
	public MovingBall (int x_initial, int y_initial, int r, Box box, MovingBar _bar) {
		x_pos = x_initial;
		y_pos = y_initial;
		radius = r;
		container = box;
		bar= _bar;
	}
	
	public int xPosition() {
		return x_pos;
	}
	
	public int yPosition() {
		return y_pos;
	}
	
	public int radiusOf() {
		return radius;
	}
	
	public void move(int time_units) {
		x_pos += x_velocity * time_units;
		if (container.inHorizontalContact(x_pos, radius))
			x_velocity = -x_velocity;
		y_pos += y_velocity * time_units;
		if (container.inVerticalContact(y_pos, radius) || bar.inVerticalContact(x_pos,y_pos,radius) )
			y_velocity = -y_velocity;
	}
	
}
