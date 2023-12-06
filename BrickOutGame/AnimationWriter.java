package movingball;
import java.awt.*;
import javax.swing.*;


public class AnimationWriter extends JPanel {
	private BoxWriter box_writer;
	private BallWriter ball_writer;
	private BarWriter bar_writer;
	private BrickWriter brick_writer;
	
	
	public AnimationWriter(BoxWriter b, BallWriter l, BarWriter r, BrickWriter k, int width, int height) {
		box_writer = b;
		ball_writer = l;
		bar_writer = r;
		brick_writer = k;
		
		JFrame my_frame = new JFrame();
		my_frame.getContentPane().add(this);
		my_frame.setTitle("BrickOutGame");
		my_frame.setSize(width+15, height+35);
		my_frame.setVisible(true);
		my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public void paintComponent(Graphics g) {
		box_writer.paint(g);
		ball_writer.paint(g);
		bar_writer.paint(g);
		brick_writer.paint(g);
	}

	
}
