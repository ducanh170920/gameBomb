package ObjectGame;

import java.awt.*;
import java.util.ArrayList;

public class Animation extends object{
    ArrayList<Image> images;
    ArrayList<Integer>TimeNext;
    int current;
    long TimeStart;
    long TimeCurrent;

    public Animation(int x, int y) {
        super(x, y);
        images = new ArrayList<Image>();
        TimeNext = new ArrayList<>();
        current = 0;
        TimeStart = 0;
    }
    void add(Image image,int time){
        images.add(image);
        TimeNext.add(time);
    }

    @Override
    public void update(int x) {


    }
    void nextFame(){
        if(current >=0 && current < TimeNext.size()-1)
            current++;
        else
            current = 0;
    }
    public void CheckTime(){
        TimeCurrent = System.currentTimeMillis();
        if(TimeCurrent - TimeStart >= TimeNext.get(current)){
            nextFame();
            TimeStart = TimeCurrent;
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(images.get(current),x,y,null);
    }
}