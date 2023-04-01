package Inputs;

import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.Objects;

public class MouseInputs implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel;
    private boolean selectedChar = false;
    private boolean justChanged = false;
    private boolean legal = false;
    private char lastChar = 'B';
    private char currentChar;
    private int[] selectedCharCoord = new int[2];
    private int x, y;
    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }


//    @Override
//    public void mousePressed(MouseEvent e) {
//        int[] selection = gamePanel.getGame().getTestChar().getCharAt(e.getX(), e.getY());
//        int[] coords = gamePanel.getGame().getChessSpace().getChessBox(e.getX(), e.getY());
//        int[][] movePossibility = gamePanel.getGame().getChessSpace().getmovePossibility(selection,selectedCharCoord);
//        int[][][] locationMap = gamePanel.getGame().getChessSpace().getChessBoxes();
//        if(movePossibility != null) {
//            for (int[] move : movePossibility) {
//                if (Arrays.equals(move, coords)) {
//                    legal = true;
//                }
//            }
//        }
//
//        x = selection[0];
//        y = selection[1];
//        if(x<2){
//            currentChar = 'W';
//        } else {
//            currentChar = 'B';
//        }
//        if(x!= 21091 && y != 21091 && !selectedChar &&(currentChar != lastChar)){
//            if(e.getX() >= 22 && e.getY() >= 10 ) {
//                gamePanel.getGame().getChessSpace().setBoxClicked(true);
//                gamePanel.getGame().getChessSpace().setCoordsInput(coords);
//                gamePanel.getGame().getChessSpace().setCoordsPiece(selection);
//                selectedCharCoord  = coords;
//            }
//            selectedChar = true;
//            lastChar = currentChar;
//        } else if(x!= 21091 && y != 21091 && selectedChar && legal){
//            selectedChar = false;
//            legal = false;
//            gamePanel.getGame().getChessSpace().setBoxClicked(false);
//            if (x != 1 && x != 2) {
//                gamePanel.getGame().getTestChar().setPosArray(locationMap[coords[0]][coords[1]][0] - 5, locationMap[coords[0]][coords[1]][1] - 25, x, y);
//            } else {
//                gamePanel.getGame().getTestChar().setPosArray(locationMap[coords[0]][coords[1]][0] - 10, locationMap[coords[0]][coords[1]][1] - 30, x, y);
//            }
//        }
//    }



    @Override
    public void mousePressed(MouseEvent e) {
        int[] selection = gamePanel.getGame().getTestChar().getCharAt(e.getX(), e.getY());
        System.out.println(Arrays.toString(selection));
        int[] coords = gamePanel.getGame().getChessSpace().getChessBox(e.getX(), e.getY());
        System.out.println(Arrays.toString(coords));
        int[][] movePossibility = gamePanel.getGame().getChessSpace().getmovePossibility(selection,selectedCharCoord);
        int[][][] locationMap = gamePanel.getGame().getChessSpace().getChessBoxes();
        if(movePossibility != null) {
            for (int[] move : movePossibility) {
                if (Arrays.equals(move, coords)) {
                    legal = true;
                }
            }
        }
        x = selection[0];
        y = selection[1];
        if(x<2){
            currentChar = 'W';
        } else {
            currentChar = 'B';
        }
        if(x!= 21091 && y != 21091 && !selectedChar &&(currentChar != lastChar)){
            if(e.getX() >= 22 && e.getY() >= 10 ) {
                gamePanel.getGame().getChessSpace().setBoxClicked(true);
                gamePanel.getGame().getChessSpace().setCoordsInput(coords);
                gamePanel.getGame().getChessSpace().setCoordsPiece(selection);
                selectedCharCoord  = coords;
            }
            selectedChar = true;
            lastChar = currentChar;
        } else if(x!= 21091 && y != 21091 && selectedChar && legal){
//            if (x != 1 && x != 2) {
//                gamePanel.getGame().getTestChar().setPosArray(locationMap[coords[0]][coords[1]][0] - 5, locationMap[coords[0]][coords[1]][1] - 25, x, y);
//            } else {
//                gamePanel.getGame().getTestChar().setPosArray(locationMap[coords[0]][coords[1]][0] - 10, locationMap[coords[0]][coords[1]][1] - 30, x, y);
//            }
            selectedChar = false;
            legal = false;
            gamePanel.getGame().getChessSpace().setBoxClicked(false);
            if (x != 1 && x != 2) {
                gamePanel.getGame().getTestChar().setPosArray(locationMap[coords[0]][coords[1]][0] - 5, locationMap[coords[0]][coords[1]][1] - 25, x, y);
            } else {
                gamePanel.getGame().getTestChar().setPosArray(locationMap[coords[0]][coords[1]][0] - 10, locationMap[coords[0]][coords[1]][1] - 30, x, y);
            }
        }
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


        if(selectedChar) {
            if (x != 1 && x != 2) {
                gamePanel.getGame().getTestChar().setPosArray(e.getX() - 50, e.getY() - 40, x, y);
            } else {
                gamePanel.getGame().getTestChar().setPosArray(e.getX() - 50, e.getY() - 40, x, y);
            }
        }
    }
}
