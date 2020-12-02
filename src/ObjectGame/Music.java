package ObjectGame;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    public  void playMusic(String path){

            File file = new File(path);
            if(file.exists()){
                AudioInputStream audioInputStream = null;
                try {
                    audioInputStream = AudioSystem.getAudioInputStream(file);
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Clip clip = null;
                try {
                    clip = AudioSystem.getClip();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
                try {
                    clip.open(audioInputStream);
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clip.start();
            }else {
                System.out.println("cant find");
            }

    }
    public  void playMusic1(String path){
        try {
            File file = new File(path);
            if(file.exists()){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            }else {
                System.out.println("cant find");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
