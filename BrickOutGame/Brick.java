package movingball;

import java.awt.*;

public class Brick extends Model {
    private boolean destroyed;

    public Brick(int x, int y) {
        x_pos = x;
        y_pos = y;
        width = 55;
        height = 20;
        destroyed = false;
    }
    
    public Rectangle brickRect() {
    	Rectangle brickRect = new Rectangle(x_pos, y_pos, width, height);
    	return brickRect;
    }

    public boolean isCollided(MovingBall ball) {
    	if (!destroyed && ball.ballRect().intersects(brickRect())) {
            destroyed = true;
            return true;
        }
        return false;
    }
    
    public String getDirection(MovingBall ball) {
        Rectangle brickRect = brickRect();
        Rectangle ballRect = ball.ballRect();

        if (brickRect.intersects(ballRect)) {
            int overlapX = Math.min(brickRect.x + brickRect.width, ballRect.x + ballRect.width) - Math.max(brickRect.x, ballRect.x);
            int overlapY = Math.min(brickRect.y + brickRect.height, ballRect.y + ballRect.height) - Math.max(brickRect.y, ballRect.y);

            if (overlapX < overlapY) {
                // x 방향 충돌
                return ball.xPosition() < this.x_pos ? "LEFT" : "RIGHT";
            } else {
                // y 방향 충돌
                return ball.yPosition() < this.y_pos ? "TOP" : "BOTTOM";
            }
        }

        return "NONE";
    }
    
    public boolean isDestroyed() {
        return destroyed;
    }
}
