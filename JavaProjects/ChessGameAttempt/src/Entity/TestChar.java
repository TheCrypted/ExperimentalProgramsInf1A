package Entity;

import Utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TestChar extends Entity{
    private BufferedImage image;
    private BufferedImage[][] images;
    private int[][][] posArray;
    private boolean right= false, up= false, left = false, down = false;
    public TestChar(int x, int y) {
        super(x, y);
        loadImage();
        posArrays();
        getPieceAt();


    }

    public void updateTestChar() {
//        updatePos();
    }
    public void render(Graphics g){
        draw(g);
//        posArrays();
        drawWhites(g);
        drawBlacks(g);
    }

    public void loadImage(){
        image = LoadSave.getPlayerAtlas(LoadSave.PLAYER_ATLAS);
        System.out.println("loadImage");
    }
    public void getPieceAt(){
        images = new BufferedImage[2][6];
        for(int i = 0; i < images.length; i++){
            for(int j = 0; j < images[0].length; j++){
                images[i][j] = image.getSubimage(j*68, i*90, 68, 90);
            }
        }
    }

    public int[] getCharAt(int x, int y){
        int[] ij = new int[2];
        ij[0] = 21091;
        ij[1] = 21091;
        for(int i = 0; i < posArray.length; i++)
            for(int j = 0; j < posArray[0].length; j++){
                if(posArray[i][j][0] <= x && x <= posArray[i][j][0]+85 &&
                        posArray[i][j][1] <= y && posArray[i][j][1] +80 >= y){
                    ij[0] = i;
                    ij[1] = j;
                }
            }
        return ij;
    }

    public int[][][] getPosArray() {
        return posArray;
    }

    private void draw(Graphics g) {
//        g.drawImage(images[0][1], x, y, (int)(68*1.2), (int)(90*1.2), null);
    }

    public void setPosArray(int x, int y, int i, int j) {
        this.posArray[i][j][0] = x;
        this.posArray[i][j][1] = y;
    }

    private void posArrays(){
        posArray = new int[4][8][2];
        for(int i = 0; i < posArray.length; i++){
            for(int j = 0; j < posArray[0].length; j++){
                if(i<2) {
                    if (j>= 5) {
                        posArray[i][j][0] = 85 * (j);
                        posArray[i][j][1] = -20 + i * 80;
                    } else {
                        posArray[i][j][0] = 10 + 85 * (j);
                        posArray[i][j][1] = -20 + i * 80;
                    }
                } else {
                    if (j>= 5) {
                        posArray[i][j][0] = 85 * (j);
                        posArray[i][j][1] = 465 + (i-2) * 80;
                    } else {
                        posArray[i][j][0] = 10 + 85 * (j);
                        posArray[i][j][1] = 465 + (i-2) * 80;
                    }
                }
            }
        }

    }

    private void drawWhites(Graphics g) {
        for(int j = 0; j < images.length; j++) {
            for (int i = 1; i <= (images[0].length - 2) * 2; i++) {
                if(j < 1) {
                    if (i >= 6) {
                        g.drawImage(images[0][9 - i], posArray[j][i-1][0], posArray[j][i-1][1], (int) (68 * 1.2), (int) (90 * 1.2), null);
                    } else {
                        g.drawImage(images[0][i], posArray[j][i-1][0], posArray[j][i-1][1], (int) (68 * 1.2), (int) (90 * 1.2), null);
                    }
                } else {
                    g.drawImage(images[0][0], posArray[j][i-1][0], posArray[j][i-1][1], (int) (68 * 1.2), (int) (90 * 1.2), null);
                }
            }
        }
    }
    private void drawBlacks(Graphics g) {
        for(int j = 0; j < images.length; j++) {
            for (int i = 1; i <= (images[1].length - 2) * 2; i++) {
                if(j < 1) {
                    g.drawImage(images[1][0], posArray[j+2][i-1][0], posArray[j+2][i-1][1], (int) (68 * 1.2), (int) (90 * 1.2), null);
                    }
                else {
                    if (i >= 6) {
                        g.drawImage(images[1][9 - i], posArray[j+2][i-1][0], posArray[j+2][i-1][1], (int) (68 * 1.2), (int) (90 * 1.2), null);
                    } else {
                        g.drawImage(images[1][i], posArray[j+2][i-1][0], posArray[j+2][i-1][1], (int) (68 * 1.2), (int) (90 * 1.2), null);
                }

                }
            }
        }
    }

//    public void updatePos(){
//        if(right && !left) {
//            x += 5;
//        } else if (!right && left) {
//            x -= 5;
//        }
//        if (down && !up) {
//            y += 5;
//        } else if (!down && up) {
//            y -= 5;
//        }
//    }
    public int getX(){
        return x;
    }

    public void setX(int x) {
        Entity.x = x;
    }
    public void setY(int y) {
        Entity.y = y;
    }

    public int getY() {
        return y;
    }


    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setLeft(boolean left) {

        this.left = left;
    }

    public void setDown(boolean down) {

        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isDown() {
        return down;
    }
}
