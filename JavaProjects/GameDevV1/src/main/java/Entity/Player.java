package Entity;

import Utils.LoadSave;
import com.example.gamedevv1.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static Utils.Constants.Directions.*;
import static Utils.Constants.Directions.DOWN;
import static Utils.Constants.PlayerConstants.*;
import static Utils.Constants.getSpriteAmount;
import static Utils.HelperFunctions.CanMovehere;
import static Utils.HelperFunctions.GetEntityXNextWall;


public class Player extends Entity{
    private static int aniTick;
    private static int aniIndex;
    private static int aniSpeed = 15;
    private static int playerAction = IDLE;
    private static boolean left;
    private static boolean right;
    private static boolean up;
    private static boolean down;
    private static int playerSpeed = 2;
    private static boolean moving = false;
    private static boolean attacking = false;
    private static BufferedImage[][] imgs;
    private int[][] lvlData;
    private static float xDrawOffset = 21 * Game.SCALE;
    private static float yDrawOffset = 4 * Game.SCALE;
    private float airSpeed = 0f;
    private float gravity = 0.04f*Game.SCALE;
    private float jumpSpeed = -2.25f * Game.SCALE;
    private float jumpSpeedAfterCollision = 0.5f * Game.SCALE;
    private boolean inAir = false;
    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadAnimations();
        initHitbox(x, y, 20*Game.SCALE, 28*Game.SCALE);
    }

    public void update(){
        updatePos();
        updateAnimation();
        setAnimation();


    }
    public void render(Graphics g){
        draw(g);
        drawHitbox(g);

    }
    private void loadAnimations(){
            BufferedImage img = LoadSave.getplayerAtlas(LoadSave.PLAYER_ATLAS);
            imgs = new BufferedImage[9][6];
            for(int j = 0; j < imgs.length; j++) {
                for (int i = 0; i < imgs[j].length; i++) {
                    imgs[j][i] = img.getSubimage(i * 64, j*40, 64, 40);
                }
            }

        }

    public void loadlvlData(int[][] lvlData){
        this.lvlData = lvlData;
    }

    public static void updateAnimation(){
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex ++;
            if(aniIndex >= getSpriteAmount(playerAction)){
                aniIndex = 0;
                attacking = false;
            }
        }
    }
    public static void setAnimation(){
        int currAnimation = playerAction;
        if (moving){
            playerAction = RUNNING;
        }
        else {
            playerAction = IDLE;
        }
        if (attacking) {
            playerAction = ATTACK_1;
        }
        if(currAnimation != playerAction){
            resetAni();
        }
    }

    private static void resetAni() {
        aniTick = 0;
        aniIndex = 0;
    }

    public static void draw(Graphics g){
        g.drawImage(imgs[playerAction][aniIndex], (int)(hitbox.x - xDrawOffset), (int)(hitbox.y - yDrawOffset), width, height, null);
    }
    public void updatePos(){
        moving = false;
        if(!left && !right && !inAir){
            return;
        }

        int xSpeed = 0;
        if (left && !right){
            xSpeed = -playerSpeed;
        }

        if(inAir){

        } else {
            updatePosX();
        }

    }

    private void updatePosX(float xSpeed) {
        if(CanMovehere(hitbox.x + xSpeed, hitbox.y + ySpeed, hitbox.width, hitbox.height, lvlData)) {
            hitbox.x += xSpeed;
        } else {
            hitbox.x = GetEntityXNextWall(hitbox.x, xSpeed);
        }
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }
    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }
}
