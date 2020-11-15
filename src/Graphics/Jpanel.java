package Graphics;

import ObjectGame.Background;
import ObjectGame.ReadFile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Jpanel extends JPanel {
    Background background = new Background(0,0);
    public Jpanel(){
        this.setBounds(0,0, Frame.width, Frame.height);
        this.setVisible(true);
    }
    public void paint(Graphics g){
      background.draw(g);
    }

}
