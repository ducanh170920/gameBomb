package ObjectGame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    private static ReadFile singleton;
    private ReadFile(){};
    public static ReadFile GetInstance(){
        if(singleton == null){
            singleton = new ReadFile();
        }
        return singleton;
    }
    public char[][] Map(){
        File file = new File("asset/Map/Lv1.txt");
        char[][]Map ;
        char[][]Map1 = new char[1][1] ;
        try {
            Scanner reader = new Scanner(file);
            String data = reader.nextLine();
            String word[] = data.split(" ");
            int height = Integer.parseInt(String.valueOf(word[1]));
            int width = Integer.parseInt(String.valueOf(word[2]));
            Map = new char[height][width];
            int i = 0;
            while (reader.hasNextLine()){
                 data = reader.nextLine();


                     for (int j = 0 ; j < width ; j++){
                         Map[i][j] = data.charAt(j);

                     }

            i++;
            }

            return  Map;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Map1;
    }
    public static BufferedImage readImage(String s){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  image;
    }



}
