package ObjectGame;

import java.awt.*;
import java.util.ArrayList;

public class WorldGame extends object{
    Background background = new Background(0,0);
    Bomber bomber = new Bomber(32,32);
    ArrayList<Monster>monsters ;
    public WorldGame(int x, int y) {
        super(x, y);
        bomber.setWorldGame(this);
        monsters = new ArrayList<>();
        initMoster();

    }

    private void initMoster() {
        monsters.add(new Minvo(32*28,32,background));
        monsters.add(new oneal(32*28,32*11,background));
        monsters.add(new oneal(32*2,32*11,background));
        monsters.add(new Minvo(32*2,32*11,background));
        monsters.add(new oneal(32*2,32*5,background));
        monsters.add(new Minvo(32*15,32*5,background));
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public Bomber getBomber() {
        return bomber;
    }

    public void setBomber(Bomber bomber) {
        this.bomber = bomber;
    }

    @Override
    public void update(int x) {
        for (Monster m : monsters){
            m.update(1);
        }
        checkColide();
        killMonster();

    }

    private void checkColide() {
        bomber.checkColide(monsters);
        if(bomber.isLive == false){
            System.out.println("die");
        }
    }
    public void killMonster(){
        Rectangle me = new Rectangle(bomber.x,bomber.y,20,20) ;
        for(Bomb b: bomber.bombs){
            for(Monster m : monsters){
                Rectangle mon = new Rectangle(m.x,m.y,32,32) ;
                if(b.exploit.current == 4)
                for(Animation a : b.animation){
                    if(mon.intersects(new Rectangle(a.x,a.y,32,32))){
                        m.isLive = false;
                        System.out.println("die");
                    }
                    if(me.intersects(new Rectangle(a.x,a.y,32,32))){
                        bomber.isLive = false;
                        System.out.println("die");
                    }
                }
            }
        }
        for(int i = 0 ; i < monsters.size() ; i++){
            if(!monsters.get(i).finnish){
                monsters.remove(i);
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        background.draw(g);
        bomber.draw(g);
        for (Monster m : monsters){
            m.draw(g);
        }
    }


}
