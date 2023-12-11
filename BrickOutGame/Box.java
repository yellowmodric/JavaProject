package movingball;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Box extends Model {

    private List<Brick> bricks;

    public Box(int _width, int _height) {
        width = _width;
        height = _height;
        bricks = new ArrayList<>();
        initializeBricks();
    }

    public void resetBricks() {
        bricks.clear(); // 기존 벽돌 제거

        // 새로운 벽돌 초기화
        initializeBricks();
    }

    private void initializeBricks() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int brickX = 12 + i * 65;
                int brickY = 10 + j * 30;

                // 벽돌 색상 설정(색깔 개구림)
                Color brickColor;
                switch (j % 4) {
                    case 0:
                        brickColor = Color.red;
                        break;
                    case 1:
                        brickColor = Color.blue;
                        break;
                    case 2:
                        brickColor = Color.yellow;
                        break;
                    case 3:
                        brickColor = Color.green;
                        break;
                    default:
                        brickColor = Color.black;
                        break;
                }
                bricks.add(new Brick(brickX, brickY, brickColor));
            }
        }
    }

    public boolean barContact(Rectangle barRect) {

        return barRect.x <= 0 || barRect.x + barRect.width >= width;
    }

    public boolean wallHorContact(int x_pos, int r) {
        int balls_right_boundary = x_pos + r * 2;
        int balls_left_boundary = x_pos;
        return balls_left_boundary <= 0 || balls_right_boundary >= width;
    }

    public boolean wallVerContact(int y_pos, int r) {
        int balls_top_boundary = y_pos;
        int balls_bottom_boundary = y_pos + r * 2;
        return balls_top_boundary <= 0 || balls_bottom_boundary >= height;
    }

    public List<Brick> getBricks() {
        return bricks;
    }
}
