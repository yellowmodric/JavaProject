package movingball;

import java.awt.Color;
import java.awt.Graphics;

public class BrickWriter {
    private Box box;
    private Color bricks_color;

    public BrickWriter(Box b, Color c) {
        box = b;
        bricks_color = c;
    }

    public void paint(Graphics g) {
        // 벽돌 그리기
        for (Brick brick : box.getBricks()) {
            int width = brick.widthOf();
            int height = brick.heightOf();
            
            if (!brick.isDestroyed()) {
                g.setColor(bricks_color);
                g.fillRect(brick.xPosition(), brick.yPosition(), width, height);
            }
        }
    }
    
}
