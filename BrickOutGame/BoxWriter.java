package movingball;

import java.awt.*;

public class BoxWriter {
    private Box box;

    public BoxWriter(Box b) {
        box = b;
    }

    public void paint(Graphics g) {
        int w = box.widthOf();
        int h = box.heightOf();
        g.setColor(Color.black);
        g.fillRect(0, 0, w, h);
        
    }
    
}
