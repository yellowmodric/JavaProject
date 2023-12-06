package movingball;

public abstract class Model {
	
	protected int x_pos, y_pos, width, height;
	
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

}
