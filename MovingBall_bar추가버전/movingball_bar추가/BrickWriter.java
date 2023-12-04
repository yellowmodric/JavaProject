package movingball;
import java.awt.*;


public class BrickWriter {
	private Brick brick;
	private Color bricks_color;
	
	public BrickWriter(Brick x, Color c) {
		brick = x;
		bricks_color = c;
	}
	
	public void paint(Graphics g) {
		g.setColor(bricks_color);
		int width = brick.widthOf();
		int height = brick.heightOf();
		g.fillRect(brick.xPosition(), brick.yPosition(), width, height);
		
        
	}

}
