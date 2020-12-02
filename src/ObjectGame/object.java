package ObjectGame;

import java.awt.*;
import java.util.ArrayList;

public abstract class object {
    protected int x;
    protected int y;

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
    public abstract void update(int x);
    public abstract void draw(Graphics g);

}
