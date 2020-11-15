package ObjectGame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background  extends object{
    char [][]Map;
    public Image wall = ReadFile.readImage("asset/wall.png");
    public Image Brick  = ReadFile.readImage("asset/brick.png");
    public Image portal = ReadFile.readImage("asset/portal.png");

    public Background(int x ,int y){
           super(x,y);
           Map = ReadFile.GetInstance().Map();
           for(int i = 0 ; i < Map.length;i++){
               for(int j =0;j < Map[0].length;j++){
                   System.out.print(Map[i][j]);
               }
               System.out.println();
           }
           wall = wall.getScaledInstance(32,32,Image.SCALE_DEFAULT);
           Brick= Brick.getScaledInstance(32,32,Image.SCALE_DEFAULT);
           portal = portal.getScaledInstance(32,32,Image.SCALE_DEFAULT);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        for(int i = 0 ; i < Map.length;i++){
            for(int j =0;j < Map[0].length;j++){
               if(Map[i][j] == '#'){
                   g.drawImage(wall,i*32,j*132,null);
               }
               else if(Map[i][j] == '*'){
                   g.drawImage(Brick,i*32,j*32,null);
               } else if(Map[i][j] == 'x'){
                   g.drawImage(portal,i*32,j*32,null);
               }
            }

        }
    }
}
