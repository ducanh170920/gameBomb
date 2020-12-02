package Graphics;

import ObjectGame.ReadFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu {
    public Rectangle playButton = new Rectangle(350+120,150,100,50);
    public Rectangle quitButton = new Rectangle(350+120,250,100,50);

    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        try {
            Image image = ImageIO.read(new File("asset/bg.png"));
            g2d.drawImage(image,0,0,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Font font = new Font("arial",Font.BOLD,50);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("BOM GAME",350+20,100);

        Font font1 = new Font("arial",Font.BOLD,30);
        g.setFont(font1);
        g.drawString("Play",playButton.x+19,playButton.y+30);
        g.drawString("Quit",quitButton.x+19,quitButton.y+30);
        g2d.draw(playButton);
        g2d.draw(quitButton);
    }
}
