package movingball;

import java.awt.Graphics;

public class BrickWriter {
    private Box box;
    
    public BrickWriter(Box b) {
        box = b;
    }

    public void paint(Graphics g) {
        // 벽돌 그리기
        for (Brick brick : box.getBricks()) {
            int width = brick.widthOf();
            int height = brick.heightOf();

            if (!brick.isDestroyed()) {
                g.setColor(brick.getBrickColor());
                g.fillRect(brick.xPosition(), brick.yPosition(), width, height);
            }
        }
    }

}
