package Entities;

import MainRun.GamePanel;
import Resources.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Clouds extends Entity {
    private BufferedImage[] clouds;
    private Random random;
    private BufferedImage image;
    private int[][] posArray;
    public Clouds() {
        random = new Random();
        loadImage();
        loadClouds();
        posArray();
    }
    public void loadImage(){
        image = LoadSave.getPlayerAtlas(LoadSave.LEVEL_ATLAS);
    }

    public int[][] getPosArray() {
        return posArray;
    }

    public void loadClouds(){
        clouds = new BufferedImage[8];
        clouds[0] = image.getSubimage(20, 35, 140, 80);
        clouds[1] = image.getSubimage(180, 35, 100, 80);
        clouds[2] = image.getSubimage(280, 35, 180, 80);
        clouds[3] = image.getSubimage(440, 55, 100, 60);
        clouds[4] = image.getSubimage(20, 115, 330, 200);
        clouds[5] = image.getSubimage(350, 115, 380, 200);
        clouds[6] = image.getSubimage(20, 115, 330, 200);
        clouds[7] = image.getSubimage(350, 115, 380, 200);
    }
    public void posArray(){
        posArray = new int[clouds.length][3];
        for(int i=0; i < clouds.length; i++){
            posArray[i][0] = random.nextInt(GamePanel.SCREEN_WIDTH - 200);
            posArray[i][1] = random.nextInt(GamePanel.SCREEN_HEIGHT - 200);
            posArray[i][2] = random.nextInt(5);
            if(posArray[i][2] == 0){
                posArray[i][2] = 1;
            }
        }
    }
    public void resetPosArray(int i){
        posArray[i][0] = -400;
        posArray[i][1] = random.nextInt(500);
        posArray[i][2] = random.nextInt(1, 4);
    }

    public void updateCloudPos(int[][] posArray){
        for(int i=0; i < clouds.length; i++){
            posArray[i][0] += posArray[i][2];
            if(posArray[i][0] >= GamePanel.SCREEN_WIDTH){
                resetPosArray(i);
            }
        }
    }
    public void draw(Graphics g){
        for(int i=0; i < clouds.length; i++){
            g.drawImage(clouds[i], posArray[i][0], posArray[i][1], null);
        }


    }
}
