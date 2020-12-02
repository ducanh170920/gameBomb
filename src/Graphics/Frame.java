package Graphics;

import ObjectGame.ReadFile;

import javax.swing.*;
import java.awt.event.KeyListener;

public class Frame extends JFrame {
    public static int width = 32*32;
    public static int height = 14*32;
    private  Jpanel jpanel = new Jpanel();
    ReadFile readFile = ReadFile.GetInstance() ;

    public Frame(){
        pack();
        setSize(width,height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(jpanel);
        readFile.Map();
        addKeyListener(jpanel);

    }
}
