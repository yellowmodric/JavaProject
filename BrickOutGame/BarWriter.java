package movingball;
import java.awt.*;

public class BarWriter {
	private MovingBar bar;
	private Color bars_color;
	
	public BarWriter(MovingBar x, Color c) {
		bar = x;
		bars_color = c;
	}
	
	public void paint(Graphics g) {
		g.setColor(bars_color);
		int width = bar.widthOf();
		int height = bar.heightOf();
		g.fillRect(bar.xPosition(), bar.yPosition(), width, height);
	}
}



