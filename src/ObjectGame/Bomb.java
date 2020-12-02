package ObjectGame;

import java.awt.*;
import java.util.ArrayList;

public class Bomb extends object {
    Animation exploit;
    Animation left;
    Animation right;
    Animation top;
    Animation down;
    private int radius;
    private int TimeExploit;
    Background background;
    ArrayList<Animation>animation;
    Music music = new Music();

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getTimeExploit() {
        return TimeExploit;
    }

    public void setTimeExploit(int timeExploit) {
        TimeExploit = timeExploit;
    }

    public Bomb(int x, int y,Background background) {
        super(x, y);
        radius = 1 * 32;
        exploit = new Animation(x,y);
        TimeExploit = 1000;
        this.background = background;
        animation = new ArrayList<>();
        initAni();
        update(0);




    }

    public ArrayList<Animation> getAnimation() {
        return animation;
    }

    public void setAnimation(ArrayList<Animation> animation) {
        this.animation = animation;
    }

    void initAni(){
        exploit.add(ReadFile.readImage("asset/bomb.png"),TimeExploit);
        exploit.add(ReadFile.readImage("asset/bomb_1.png"),TimeExploit);
        exploit.add(ReadFile.readImage("asset/bomb_2.png"),TimeExploit);
        exploit.add(ReadFile.readImage("asset/bomb_exploded.png"),TimeExploit-500);
        exploit.add(ReadFile.readImage("asset/bomb_exploded1.png"),TimeExploit-500);
        exploit.add(ReadFile.readImage("asset/bomb_exploded2.png"),TimeExploit-500);
        animation.add(exploit);





    }

    @Override
    public void update(int xa) {
        if(background.Map[y/32][(x-radius)/32] != '#') {
            left = new Animation(x - radius, y);
            left.add(ReadFile.readImage("asset/explosion_horizontal_left_last.png"),TimeExploit);
            left.add(ReadFile.readImage("asset/explosion_horizontal_left_last1.png"),TimeExploit);
            left.add(ReadFile.readImage("asset/explosion_horizontal_left_last2.png"),TimeExploit);
            animation.add(left);

        }
        if(background.Map[y/32][x/32+radius/32] != '#') {
            right = new Animation(x+radius,y);
            right.add(ReadFile.readImage("asset/explosion_horizontal_right_last.png"),TimeExploit);
            right.add(ReadFile.readImage("asset/explosion_horizontal_right_last1.png"),TimeExploit);
            right.add(ReadFile.readImage("asset/explosion_horizontal_right_last2.png"),TimeExploit);
            animation.add(right);

        }
        if(background.Map[y/32-radius/32][x/32] != '#') {
            top = new Animation(x,y-radius);
            top.add(ReadFile.readImage("asset/explosion_vertical_top_last.png"),TimeExploit);
            top.add(ReadFile.readImage("asset/explosion_vertical_top_last1.png"),TimeExploit);
            top.add(ReadFile.readImage("asset/explosion_vertical_top_last2.png"),TimeExploit);
            animation.add(top);

        }
        if(background.Map[y/32+radius/32][x/32]!= '#') {
            down = new Animation(x,y+radius);
            down.add(ReadFile.readImage("asset/explosion_vertical_down_last.png"),TimeExploit);
            down.add(ReadFile.readImage("asset/explosion_vertical_down_last1.png"),TimeExploit);
            down.add(ReadFile.readImage("asset/explosion_vertical_down_last2.png"),TimeExploit);
            animation.add(down);
        }


    }
    public boolean finnish(){
        if(exploit.current == 5)
            return true;
        return false;
    }

    @Override
    public void draw(Graphics g) {
        exploit.draw(g);
        exploit.CheckTime();
        if(exploit.current >=4) {
            for(int i = 1 ; i < animation.size();i++)
            {
                animation.get(i).draw(g);
                background.Map[animation.get(i).getY()/32][animation.get(i).getX()/32] = ' ';
                animation.get(i).CheckTime();
            }
            background.Map[getY()/32][getX()/32] = ' ';
            if(background.Map[3][3] == ' ')
            background.Map[3][3] = 'x';
            if(background.Map[11][5] == ' ')
            background.Map[11][5] = 'x';

        }
    }
}
