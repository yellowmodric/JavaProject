package movingball;
import java.awt.*;
import javax.swing.*;


public class AnimationWriter extends JPanel {
	private BoxWriter box_writer;
	private BallWriter ball_writer;
	
	public AnimationWriter(BoxWriter b, BallWriter l, int size) {
		box_writer = b;
		ball_writer = l;
		JFrame my_frame = new JFrame();
		my_frame.getContentPane().add(this);
		my_frame.setTitle("Bounce");
		my_frame.setSize(size, size);
		my_frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		box_writer.paint(g);
		ball_writer.paint(g);
	}
}
