package Levels;

import Utils.LoadSave;
import com.example.gamedevv1.Game;

import java.awt.*;
import java.awt.image.BufferedImage;


public class LevelManager {
    public levelA levelOne;
    public Game game;
    private BufferedImage[] levelSprite;
    public LevelManager(Game game){
        this.game = game;
        loadLevelSprites();
        levelOne = new levelA(LoadSave.getLevelData());
//        levelSprite = LoadSave.getplayerAtlas(LoadSave.LEVEL_ATLAS);
    }

    private void loadLevelSprites() {
        BufferedImage img = LoadSave.getplayerAtlas(LoadSave.LEVEL_ATLAS);
        levelSprite = new BufferedImage[48];
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 12; i++) {
                int index = j*12 + i;
                levelSprite[index] = img.getSubimage(i*32, j*32, 32, 32);
            }

        }
    }

    public void draw(Graphics g){
        for(int i = 0; i < Game.GAME_HEIGHT_TILES; i++){
            for(int j = 0; j < Game.GAME_WIDTH_TILES; j++){
                int index = levelOne.getSpriteIndex(j, i);
                g.drawImage(levelSprite[index], Game.TILESIZE * j, Game.TILESIZE * i, Game.TILESIZE, Game.TILESIZE, null);
            }
        }
    }
    public void update(){

    }
    public levelA getCurrentLevel(){
        return levelOne;
    }
}
