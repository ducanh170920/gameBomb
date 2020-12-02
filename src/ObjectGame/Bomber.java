package ObjectGame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Bomber extends object {
    public boolean finnish;
    Animation  left;
    Animation right;
    Animation up;
    Animation down;
    int speed;
    int ori = 4;
    WorldGame worldGame;
    ArrayList<Bomb>bombs;
    long startTime;
    long CurrentTime;
    int size = 20;
    int timeHasBomb = 3000;
    boolean isLive ;
    Animation die ;
    Music music = new Music();

    public Bomber(int x, int y) {
        super(x, y);
        initAnimation();
        bombs = new ArrayList<>();
        startTime = System.currentTimeMillis();
        speed = 3;
        isLive = true;
        finnish = true;
    }

    public void setWorldGame(WorldGame worldGame) {
        this.worldGame = worldGame;
    }

    void initAnimation(){
        left = new Animation(x,y);
        left.add(ReadFile.readImage("asset/player_left.png"),  80);
        left.add(ReadFile.readImage("asset/player_left_1.png"),  80);
        left.add(ReadFile.readImage("asset/player_left_2.png"),  80);
        right = new Animation(x,y);
        right.add(ReadFile.readImage("asset/player_right.png"),  80);
        right.add(ReadFile.readImage("asset/player_right_1.png"),  80);
        right.add(ReadFile.readImage("asset/player_right_2.png"),  80);
        up = new Animation(x,y);
        up.add(ReadFile.readImage("asset/player_up.png"),  80);
        up.add(ReadFile.readImage("asset/player_up_1.png"),  80);
        up.add(ReadFile.readImage("asset/player_up_2.png"),  80);
        down = new Animation(x,y);
        down.add(ReadFile.readImage("asset/player_down.png"),  80);
        down.add(ReadFile.readImage("asset/player_down_1.png"),  80);
        down.add(ReadFile.readImage("asset/player_down_2.png"),  80);
        die = new Animation(x,y);
        die.add(ReadFile.readImage("asset/player_dead1.png"),  500);
        die.add(ReadFile.readImage("asset/player_dead2.png"),  500);
        die.add(ReadFile.readImage("asset/player_dead3.png"),  500);
    }

    @Override
    public void update(int step) {
        switch (step){
            case KeyEvent.VK_UP:

                ori = 1;
                up.CheckTime();
                if (worldGame.getBackground().checkCollisonWithMap(new Rectangle(x,y-1  ,size,size),1))
                    break;

                y=y-speed;
                animationUpdate();
                break;
            case KeyEvent.VK_DOWN:
                ori = 2;
                down.CheckTime();

                if (worldGame.getBackground().checkCollisonWithMap(new Rectangle(x+6,y+12,size,size),2))
                    break;
                y=y+speed;

                animationUpdate();
                break;
            case KeyEvent.VK_LEFT:
                left.CheckTime();
                ori = 3;
                if (worldGame.getBackground().checkCollisonWithMap(new Rectangle(x-1,y+6,size,size),3))
                    break;
                x=x-speed;
                animationUpdate();
                break;
            case KeyEvent.VK_RIGHT:
                right.CheckTime();
                ori =4;

                if (worldGame.getBackground().checkCollisonWithMap(new Rectangle(x+1,y+6,size,size),4))
                    break;
                x=x+speed;
                animationUpdate();
                break;
            case KeyEvent.VK_SPACE:
                music.playMusic("asset/Music/dk-a2600_walk.wav");
                CurrentTime = System.currentTimeMillis();
                if(CurrentTime-startTime >= timeHasBomb) {
                    bombs.add(new Bomb((x+10)/32*32, (y+10)/32*32, worldGame.background));
                    startTime = CurrentTime;
                }
                break;
            case KeyEvent.VK_ENTER:
                Rectangle rec = new Rectangle(3*32,3*32,32,32);
                if(rec.contains(new Point(this.x +16,this.y+16))){
                    Graphics.Jpanel
                }
                if(rec.contains(new Point(this.x +16,this.y+16))){

                }
                break;
        }


    }

    private boolean checkBom(Rectangle rectangle) {
        for(Monster monster : worldGame.monsters){
            for(Bomb b : monster.bombs){
                if(rectangle.intersects(new Rectangle(b.x,b.y,32,32))){
                    return true;
                }
            }
        }
        return false;
    }

    void animationUpdate(){
        right.setY(y);
        right.setX(x);
        left.setY(y);
        left.setX(x);
        up.setY(y);
        up.setX(x);
        down.setY(y);
        down.setX(x);
        die.setY(y);
        die.setX(x);
    }
    @Override
    public void draw(Graphics g) {
        //g.drawRect(x+1,y+1,30,30);
        for(int i = 0 ; i < bombs.size();i++){
            bombs.get(i).draw(g);
            if(bombs.get(i).finnish()){
                music.playMusic("asset/Music/sm64_bullet_bill_blaster.wav");
                bombs.remove(i);
            }
        }
        if(isLive) {
            switch (ori) {
                case 1:
                    up.draw(g);
                    break;
                case 2:
                    down.draw(g);
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
            if(die.current == 2){
                finnish = false;
            }
        }

    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public void checkColide(ArrayList<Monster> monsters){
        Rectangle me = new Rectangle(x+6,y+6,20,20) ;
        for(Monster m : monsters){
            if(me.intersects(new Rectangle(m.x,m.y,32,32))){
                isLive = false;
            }
            for(Bomb b : m.bombs){
                if(b.exploit.current == 4)
                for(Animation a : b.animation)
                if(me.intersects(new Rectangle(a.x,a.y,32,32))){
                    isLive = false;
                }
            }
        }

    }
}
