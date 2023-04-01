package Entities;

import Inputs.MouseInputs;
import MainRun.GamePanel;
import Resources.LoadSave;

import java.awt.*;
import java.util.Random;

public class Connect4 extends Entity {
    private int[][][] posArray;
    private int[][][] coinsMovement;
    private int[][] coinState;
    private boolean[][] connected;
    private Random random;
    private boolean winCheck = false;
    private boolean winCheckAlpha = false;
    private boolean[][] color;
    private double x = 312;
    private double y = 0;
    private double vx = 0;
    private double vy = 0;
    private double g = 0.1;
    private int[] dropping = {5, 3};
    public Connect4() {
        createPosArray();
        createCoinState();
        random = new Random();
    }

    public boolean[][] getConnected() {
        return connected;
    }

    public void setWinCheck(boolean winCheck) {
        this.winCheck = winCheck;
    }

    public void draw(Graphics g) {
        if(!connected[dropping[0]][dropping[1]]) {
            if(coinState[dropping[0]][dropping[1]] == 1){
                g.setColor(new Color(90,53,83));
            } else {
                g.setColor(new Color(11,17,43));
            }
            g.fillOval((int) x, (int) y, 75, 75);
            updateCoin();
        }
        for(int i = 0; i < connected.length; i++){
            for(int j = 0; j < connected[i].length; j++){
                if(connected[i][j]){
                    if(coinState[i][j] == 1){
                        g.setColor(new Color(90,53,83));
                    } else {
                        g.setColor(new Color(11,17,43));
                    }
                        g.fillOval(posArray[i][j][1], posArray[i][j][0], 75, 75);
                }
            }
        }
        // GRID LINES FOR REFERENCE
//        g.setColor(Color.BLACK);
//        for(int i=0; i<posArray.length; i++){
//            for(int j=0; j<posArray[i].length; j++){
//                g.drawRect(posArray[i][j][1], posArray[i][j][0], 100, 100);
//            }
//        }
    }
    public int[][] getCoinState() {
        return coinState;
    }
    public void createCoinState(){
        coinState = new int[6][7];
        for(int i=0; i<coinState.length; i++){
            for(int j=0; j<coinState[i].length; j++){
                coinState[i][j] = 3;
            }
        }
        coinState[5][3] = 0;
    }
    public void setCoinState(int i, int j, int val){
        coinState[i][j] = val;
    }

    public void updateCoin(){
        if(y + 100 <= posArray[dropping[0]][dropping[1]][0]){
            y += vy;
            vy += g;
            setCoinPos(x, y);
        } else {
            setConnected(dropping[0], dropping[1], true);
            if(winCheck){
                winCheckAlpha = true;
            }
        }
    }

    public boolean isWinCheckAlpha() {
        return winCheckAlpha;
    }

    public void setDropping(int[] dropping) {
        this.dropping = dropping;
    }
    public int[][][] getPosArray() {
        return posArray;
    }
    public void createPosArray() {
        posArray = new int[6][7][2];
        connected = new boolean[6][7];
        for (int i = 0; i < posArray.length; i++){
            for(int j = 0; j < posArray[i].length; j++){
                posArray[i][j][0] = (i+1)*100;
                posArray[i][j][1] = j*100+12;
            }
        }
        for(int i = 0; i < connected.length; i++){
            for(int j = 0; j< connected[i].length;j++){
                connected[i][j] = false;
            }
        }
    }
    public void resetXY(){
        this.x = 0;
        this.y = 0;
    }
    public void resetVel(){
        this.vy = 0;
    }
    public void setCoinPos(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void setConnected(int i, int j, boolean val){
        connected[i][j] = val;
    }
    public int[] findDropPoint(int x){
        for(int i=0; i< posArray.length; i++){
            if(!connected[posArray.length-i-1][x]){
                int[] val = {posArray.length-i-1, x};
                return val;
            }
        }
        return null;
    }

}
