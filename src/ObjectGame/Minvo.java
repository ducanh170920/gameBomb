package ObjectGame;

import java.awt.*;
import java.util.ArrayList;

public class Minvo extends Monster {



    public Minvo(int x, int y,Background background) {
        super(x, y,background);
        initAnimation();
    }
    void initAnimation(){
        left.add(ReadFile.readImage("asset/minvo_left1.png"),  80);
        left.add(ReadFile.readImage("asset/minvo_left2.png"),  80);
        left.add(ReadFile.readImage("asset/minvo_left3.png"),  80);
        right.add(ReadFile.readImage("asset/minvo_right1.png"),  80);
        right.add(ReadFile.readImage("asset/minvo_right2.png"),  80);
        right.add(ReadFile.readImage("asset/minvo_right3.png"),  80);
        die.add(ReadFile.readImage("asset/minvo_dead.png"),  500);


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
