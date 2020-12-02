package ObjectGame;

import java.awt.*;

public class Background  extends object {
    char[][] Map;
    public Image wall = ReadFile.readImage("asset/wall.png");
    public Image Brick = ReadFile.readImage("asset/brick.png");
    public Image portal = ReadFile.readImage("asset/portal.png");

    public Background(int x, int y) {
        super(x, y);
        Map = ReadFile.GetInstance().Map();
        for (int i = 0; i < Map.length; i++) {
            for (int j = 0; j < Map[0].length; j++) {
                System.out.print(Map[i][j]);
            }
            System.out.println();
        }
        Map[3][3] = '*';
        Map[5][11] = '*';
    }

    @Override
    public void update(int x) {

    }

    public boolean checkCollisonWithMap(Rectangle me, int ori) {
        int x1 = me.x / 32 ;
        int y1 = me.y / 32 ;
        int x2 = me.x / 32 + 1 ;
        int y2 = me.y / 32 +1;
        if(x1<=0) x1 =0;
        if(y1 <=0)y1 = 0;
        int size = 32;
        switch (ori) {
            case 1:
                for (int i = x1; i <= x2; i++) {
                    Rectangle r = new Rectangle(i * 32, y1 * 32, size, size);
                    if (Map[y1][i] == '#'||Map[y1][i] == '*') {
                        if (r.intersects(me)) {
                            return true;
                        }
                    }
                 }
                break;
            case 2:
                for (int i = x1; i <= x2; i++) {
                    Rectangle r = new Rectangle(i * 32, y2 * 32, size, size);
                    if (Map[y2][i] == '#'||Map[y2][i] == '*') {
                        if (r.intersects(me)) {
                            return  true;
                        }
                    }
                }
                break;
            case 3:
                for (int i = y1; i <= y2; i++) {
                    Rectangle r = new Rectangle(x1 * 32, i * 32, size, size);
                    if (Map[i][x1] == '#'||Map[i][x1] == '*') {
                        if (r.intersects(me)) {
                            return  true;
                        }
                    }
                }
                break;
            case 4:
                for (int i = y1; i <= y2; i++) {
                    Rectangle r = new Rectangle(x2 * 32, i * 32, size, size);
                    if (Map[i][x2] == '#'||Map[i][x2] == '*') {
                        if (r.intersects(me)) {
                            return  true;
                        }
                    }
                }
                break;


    }
        return false;

}
    @Override
    public void draw(Graphics g) { ;

        for(int i = 0 ; i < Map.length;i++){
            for(int j =0;j < Map[0].length;j++){
               if(Map[i][j] == '#'){
                   g.setColor(Color.RED);
                 //  g.drawRect(i*32,j*32,32,32);
                   g.drawImage(wall,j*32,i*32,null);
               }
               else if(Map[i][j] == '*'){
                   g.drawImage(Brick,j*32,i*32,null);
               } else if(Map[i][j] == 'x'){
                   g.drawImage(portal,j*32,i*32,null);
               }
            }

        }
    }
}
