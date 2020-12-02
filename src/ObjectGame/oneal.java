package ObjectGame;

import java.awt.*;

public class oneal extends Monster {
    public oneal(int x, int y, Background background) {
        super(x, y, background);
        initAnimation();
    }
    void initAnimation(){
        left.add(ReadFile.readImage("asset/oneal_left1.png"),  80);
        left.add(ReadFile.readImage("asset/oneal_left2.png"),  80);
        left.add(ReadFile.readImage("asset/oneal_left3.png"),  80);
        right.add(ReadFile.readImage("asset/oneal_right1.png"),  80);
        right.add(ReadFile.readImage("asset/oneal_right2.png"),  80);
        right.add(ReadFile.readImage("asset/oneal_right3.png"),  80);
        die.add(ReadFile.readImage("asset/oneal_dead.png"),  500);

    }

    @Override
    public void update(int x) {
        super.update(1);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }
}
