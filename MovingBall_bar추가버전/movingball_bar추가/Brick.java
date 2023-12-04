package movingball;

public class Brick {
	private int x_pos, y_pos;
	private int width = 60; //벽돌의 가로길이
	private int height = 15; //벽돌의 세로길이
	private Boolean destroyed;
	
	public Brick (int x_initial, int y_initial) {
		x_pos = x_initial;
		y_pos = y_initial;
		this.destroyed = false;	
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
	
	public boolean isDestroyed() {
        return destroyed;
    }

    


}
