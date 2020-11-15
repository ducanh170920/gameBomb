package Graphics;

import ObjectGame.ReadFile;

import javax.swing.*;

public class Frame extends JFrame {
    public static int height = 1000;
    public static int width = 1000;
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

    }
}
