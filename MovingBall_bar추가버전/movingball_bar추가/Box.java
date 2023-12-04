package movingball;
import java.util.ArrayList;
import java.util.List;

public class Box {
	private int BOX_SIZE;
	private List<Brick> bricks;
	
	public Box(int size) {
		BOX_SIZE = size;
		this.bricks = new ArrayList<>();
        initializeBricks();
	}
	
	private void initializeBricks() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                int brickX = 60 + i * 60;
                int brickY = 60 + j * 15;
                bricks.add(new Brick(brickX, brickY));
            }
        }
    }

    public List<Brick> getBricks() {
        return bricks;
    }
	
	public boolean inContact(int x_position, int w) {
		int bars_right_boundary = x_position + w;
		int bars_left_boundary = x_position;
		return bars_left_boundary <= 0 || bars_right_boundary >= BOX_SIZE;
	}
	
	public boolean inHorizontalContact(int x_position, int r) {
		int balls_right_boundary = x_position + r*2;
		int balls_left_boundary = x_position;
		return balls_left_boundary <= 0 || balls_right_boundary >= BOX_SIZE;
	}
	
	public boolean inVerticalContact(int y_position, int r) {
		int balls_top_boundary = y_position;
		int balls_bottom_boundary = y_position + r*2;
		return balls_top_boundary <= 0 || balls_bottom_boundary >= BOX_SIZE;
	}
	
	public int sizeOf() {
		return BOX_SIZE;
	}
}
