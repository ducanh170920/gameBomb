package ObjectGame;

import java.awt.*;

public abstract class object {
    private int x;
    private int y;

    public object(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public abstract void update();
    public abstract void draw(Graphics g);
}
