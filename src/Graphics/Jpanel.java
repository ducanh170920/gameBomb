package Graphics;

import ObjectGame.Background;
import ObjectGame.Music;
import ObjectGame.ReadFile;
import ObjectGame.WorldGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Jpanel extends JPanel implements ActionListener, KeyListener {
    public static enum STATE{
        MENU,GAME,WIN,
    };
    Music music = new Music();
    Menu menu;
    public static STATE state = STATE.MENU;

    Timer t = new Timer(70,this);
    WorldGame worldGame = new WorldGame(0,0);
    public Jpanel(){
        this.setBounds(0,0, Frame.width, Frame.height);
        this.setVisible(true);
        menu = new Menu();
        this.addMouseListener(new MouseInput());
        music.playMusic1("asset/Music/a.wav");
    }


    public void paint(Graphics g){
        t.start();
        if(state == STATE.GAME) {
            super.paint(g);
            worldGame.draw(g);

        }else if (state == STATE.MENU){
            menu.render(g);
        }

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(state == STATE.GAME) {
            if (worldGame.getBomber().finnish) {
                worldGame.update(0);
                repaint();
            }
            else{
                state = STATE.MENU;
                worldGame = new WorldGame(0,0);
                repaint();
            }
        }
        System.out.println(state);


    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        worldGame.getBomber().update(keyEvent.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        worldGame.getBomber().update(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        worldGame.getBomber().update(keyEvent.getKeyCode());

    }
}
