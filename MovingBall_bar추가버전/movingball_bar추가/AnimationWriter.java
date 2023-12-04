package movingball;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class AnimationWriter extends JPanel {
	private BoxWriter box_writer;
	private BallWriter ball_writer;
	private BarWriter bar_writer;
	private BrickWriter brick_writer;
	
	public AnimationWriter(BoxWriter b, BallWriter l, BarWriter r, BrickWriter k, int size) {
		box_writer = b;
		ball_writer = l;
		bar_writer = r;
		brick_writer = k;
		
		JFrame my_frame = new JFrame();
		my_frame.getContentPane().add(this);
		my_frame.setTitle("Bounce");
		my_frame.setSize(size, size);
		my_frame.setVisible(true);
		my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void paintComponent(Graphics g) {
		box_writer.paint(g);
		ball_writer.paint(g);
		bar_writer.paint(g);
		for (Brick brick : box.getBricks())
            brick_writer.paint(g);
	}

	
}
