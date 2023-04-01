package Inputs;

import MainRun.GamePanel;
import UtilFunctions.Manager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;

public class MouseInputs implements MouseListener, MouseMotionListener {
    public GamePanel gamePanel;
    private int count = 0;
    public MouseInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public int[] getCoord(int x){
        int[][][] posArray = gamePanel.getGame().getConnect4().getPosArray();
        int[] output = {21091, 21091};
        for(int i=0; i<posArray[0].length; i++){
//            System.out.println(posArray[0][i][1] + " ||| " + (x-50));
            if(posArray[0][i][1] <= x && posArray[0][i][1] +100 >= x){
                output[0] = i;
                output[1] = posArray[0][i][1];
                break;
            }
        }
        return output;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int[] inputCoord = getCoord(e.getX());
        int[] dropPoint = gamePanel.getGame().getConnect4().findDropPoint(inputCoord[0]);
        gamePanel.getGame().getConnect4().setDropping(dropPoint);
        if(inputCoord[1] != 21091) {
            gamePanel.getGame().getConnect4().setCoinPos(inputCoord[1], 0);
            gamePanel.getGame().getConnect4().resetVel();
        }
        if(count%2 ==0){
            gamePanel.getGame().getConnect4().setCoinState(dropPoint[0], dropPoint[1], 1);
        } else {
            gamePanel.getGame().getConnect4().setCoinState(dropPoint[0], dropPoint[1], 0);
        }
        int victor = Manager.checkWin(gamePanel.getGame().getConnect4().getCoinState());
        if(victor != 21091 && victor != 3 ){
            gamePanel.getGame().getConnect4().setWinCheck(true);
            System.out.println("Player " + playerToColor(victor) + " WINS!!!");
        }
        count++;

    }
    public String playerToColor(int victor) {
        if(victor == 0){
            return "BLUE";
        } else {
            return "PURPLE";
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
