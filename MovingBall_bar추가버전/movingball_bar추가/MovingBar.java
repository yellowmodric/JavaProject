package movingball;

public class MovingBar {
	private int x_pos, y_pos;
	private int x_speed = 25;
	private int width = 90; //bar의 가로길이
	private int height = 10; //bar의 세로길이
	private Box container;
	
	public MovingBar (int x_initial, int y_initial, Box box) {
		x_pos = x_initial;
		y_pos = y_initial;
		container = box;
	}
	
	public int xPosition() {
		return x_pos;
	}
	
	public int yPosition() {
		return y_pos;
	}
	
	public int widthOf() {
		return width;
	}
	
	public int heightOf() {
		return height;
	}
	
	public boolean inVerticalContact(int x_position, int y_position, int r) {
		int balls_xBoundary = x_position + r;
		int balls_yBoundary = y_position + r*2;
		return (balls_xBoundary >= x_pos && balls_xBoundary <= x_pos+width ) && balls_yBoundary == y_pos;
	}
	
	public void moveLeft(int time_units) {
		x_pos -= x_speed * time_units;
		if (container.inContact(x_pos, width))
			x_pos = 0;
	}
	
	public void moveRight(int time_units) {
		x_pos += x_speed * time_units;
		if (container.inContact(x_pos, width))
			x_pos = 510;
	}
	
}
