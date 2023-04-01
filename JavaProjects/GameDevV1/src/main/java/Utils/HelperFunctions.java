package Utils;

import com.example.gamedevv1.Game;
import java.awt.geom.Rectangle2D;



public class HelperFunctions {
    public static boolean CanMovehere(float x, float y, float width, float height, int[][] lvlData){
        if(!isSolid(x, y, lvlData)){
            if(!isSolid(x+width, y+height, lvlData)){
                if(!isSolid(x+width, y, lvlData)){
                    return !isSolid(x, y + height, lvlData);
                }
            }
        }
        return false;
    }
    public static float GetEntityXNextWall(Rectangle2D.Float hitbox,  float xSpeed){
        int currentTile = (int)((hitbox.x)/Game.TILESIZE);
        if(xSpeed > 0){
            int tileXPos = (int)currentTile*Game.TILESIZE;
            int tileOffset = (int) (tileXPos - hitbox.width);
            return tileXPos + tileOffset -1;

        } else {
            return currentTile * Game.TILESIZE;
        }
    }
    private static boolean isSolid(float x, float y, int[][] lvlData){
        if(x < 0 || x >= Game.GAME_WIDTH){
            return true;
        }
        if(y < 0 || y >= Game.GAME_HEIGHT){
            return true;
        }
        float xIndex = x/Game.TILESIZE;
        float yIndex = y/Game.TILESIZE;
        int value = lvlData[(int)yIndex][(int)xIndex];
        if(value != 11){
            return true;
        }
        return false;
    }
}
