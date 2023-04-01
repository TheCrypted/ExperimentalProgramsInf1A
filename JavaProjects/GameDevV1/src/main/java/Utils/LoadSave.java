package Utils;

import com.example.gamedevv1.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {
    public static final String PLAYER_ATLAS = "CharacterSprite.png";
    public static final String LEVEL_ATLAS = "OutsideSprite.png";
    public static final String LEVEL_ONE_DATA = "level_one_data.png";
    public static BufferedImage getplayerAtlas(String filename){
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + filename);
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }
    public static int[][] getLevelData(){
        int[][] lvlData = new int[Game.GAME_HEIGHT_TILES][Game.GAME_WIDTH_TILES];
        BufferedImage img = getplayerAtlas(LEVEL_ONE_DATA);
        for(int j = 0; j<img.getHeight(); j++){
            for(int i = 0; i< img.getWidth(); i++){
                Color color = new Color(img.getRGB(i, j));
                int value = color.getRed();
                if(value>=48){
                    value = 0;
                }
                lvlData[j][i] = value;
            }
        }
        return lvlData;

    }
}
