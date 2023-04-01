package Resources;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
public class LoadSave {
    public static final String PLAYER_ATLAS = "CoinPNG.PNG";
    public static final String LEVEL_ATLAS = "clouds.png";
    public static final String LEVEL_LOAD = "";
    public static BufferedImage getPlayerAtlas(String filename){
        BufferedImage image = null;
        InputStream is = LoadSave.class.getResourceAsStream(filename);
        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }
}
