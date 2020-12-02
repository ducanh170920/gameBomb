package ObjectGame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Monster  extends  object{
    int speed = 1;
    Animation left;
    Animation right;
    Animation die;
    int ori = 1;
    Background background;
    int size = 20;
    long startTime;
    long CurrentTime;
    long timeHasBomb ;
    ArrayList<Bomb>bombs;
    boolean isLive ;
    boolean finnish;


    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public Monster(int x, int y, Background background) {
         super(x, y);
         left = new Animation(x,y);
         right = new Animation(x,y);
         die = new Animation(x,y);
         this.background = background;
         startTime = System.currentTimeMillis();
         bombs = new ArrayList<>();
         timeHasBomb = random()*1000+8000;
         isLive = true;
         finnish = true;
    }

    @Override
    public void update(int xa) {
        CurrentTime = System.currentTimeMillis();
        if(CurrentTime-startTime >= timeHasBomb) {
            bombs.add(new Bomb((x+10)/32*32, (y+10)/32*32, background));
            startTime = CurrentTime;
        }


        switch (ori){
            case 1:

                left.CheckTime();
                if (background.checkCollisonWithMap(new Rectangle(x,y-1,size,size),1)){
                    ori = random();
                    break;
                }
                y=y-speed;
                animationUpdate();
                break;
            case 2:

                right.CheckTime();
                if (background.checkCollisonWithMap(new Rectangle(x+6,y+12,size,size),2)) {
                    ori = random();
                    break;
                }
                y=y+speed;

                animationUpdate();
                break;
            case 3:
                left.CheckTime();

                if (background.checkCollisonWithMap(new Rectangle(x-1,y+6,size,size),3)){
                    ori = random();
                    break;
                }
                x=x-speed;
                animationUpdate();
                break;
            case 4:
                right.CheckTime();
                if (background.checkCollisonWithMap(new Rectangle(x+12,y+6,size,size),4)){
                    ori = random();
                    break;
                }
                x=x+speed;
                animationUpdate();
                break;
        }

    }
    int random(){
        Random ran = new Random();
        int a = ran.nextInt(4)+1;
        System.out.println("a="+a);
        return a;
    }

    @Override
    public void draw(Graphics g) {
        for(int i = 0 ; i < bombs.size();i++){
            bombs.get(i).draw(g);
            if(bombs.get(i).finnish())
                bombs.remove(i);
        }
        if(isLive){
        switch (ori){
            case 1:
                left.draw(g);
                break;
            case 2:
                right.draw(g);
                break;
            case 3:
                left.draw(g);
                break;
            case 4:
                right.draw(g);
                break;

        }
        }
        else {
            die.draw(g);
            die.CheckTime();
            if(die.current == 0){
                finnish = false;
            }
        }

    }

    private void animationUpdate() {
        right.setY(y);
        right.setX(x);
        left.setY(y);
        left.setX(x);
        die.setY(y);
        die.setX(x);
    }
}
