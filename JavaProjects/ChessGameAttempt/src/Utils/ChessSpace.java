package Utils;

import Constants.ChessPieces;
import Entity.TestChar;
import Inputs.MouseInputs;

import java.awt.*;

public class ChessSpace {
    private int[][][] chessBoxes;
    private boolean boxClicked;
    private int[] coordsInput;
    private int[] coordsPiece;
    public ChessSpace(){
        chessGen();
    }

    public void setBoxClicked(boolean boxClicked) {
        this.boxClicked = boxClicked;
    }

    public void setCoordsPiece(int[] coordsPiece) {
        this.coordsPiece = coordsPiece;
    }

    public void setCoordsInput(int[] coordsInput) {
        this.coordsInput = coordsInput;
    }

    public void chessGen(){
        chessBoxes = new int[8][8][2];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++) {
//                if((i+j)%2 == 0){
//                    g.setColor(Color.BLACK);
//                } else {
//                    g.setColor(Color.WHITE);
//                }
                chessBoxes[i][j][0] = 25 + 80 * i;
                chessBoxes[i][j][1] = 10 + j*80;
//                g.fillRect(25 + 80 * i, 10 + j*80, 88, 86);
            }
        }
//        g.fillRect(25, 10, 80,80);
    }

    public boolean isBoxClicked() {
        return boxClicked;
    }

    public void render(Graphics g){
        paintChessBox(coordsInput, g);
    }

    public int[][] getmovePossibility(int[] coord, int[] boxCoord){
        if(coord[0] == 1){
            if(boxCoord[1] == 1) {
                int[][] pawnPoss = new int[2][2];
                pawnPoss[0][0] = boxCoord[0];
                pawnPoss[0][1] = boxCoord[1] + 1;
                pawnPoss[1][0] = boxCoord[0];
                pawnPoss[1][1] = boxCoord[1] + 2;
                return pawnPoss;
            } else {
                int[][] pawnPoss = new int[1][2];
                pawnPoss[0][0] = boxCoord[0];
                pawnPoss[0][1] = boxCoord[1] + 1;
                return pawnPoss;
            }
        } else if (coord[0] == 2) {
            if(boxCoord[1] == 6) {
                int[][] pawnPoss = new int[2][2];
                pawnPoss[0][0] = boxCoord[0];
                pawnPoss[0][1] = boxCoord[1] - 1;
                pawnPoss[1][0] = boxCoord[0];
                pawnPoss[1][1] = boxCoord[1] - 2;
                return pawnPoss;
            } else {
                int[][] pawnPoss = new int[1][2];
                pawnPoss[0][0] = boxCoord[0];
                pawnPoss[0][1] = boxCoord[1] - 1;
                return pawnPoss;
            }
        }
        else if(coord[0] ==  0 || coord[0] == 3){
            if(coord[1] == 0 || coord[1] == 7){
                return ChessPieces.getMoveRook(boxCoord);
            } else if(coord[1] == 2 || coord[1] ==5){
                return ChessPieces.getMoveBishop(boxCoord);
            } else if(coord[1] == 1 || coord[1] == 6){
                return ChessPieces.getMoveKnight(boxCoord);
            } else if(coord[1] == 3) {
                return ChessPieces.getMoveQueen(boxCoord);
            } else if(coord[1] == 4){
                return ChessPieces.getMoveKing(boxCoord);
            }
        }
        return null;
    }
    public void paintChessBox(int[] coord, Graphics g){
        if (boxClicked && coord[0] != 29109) {
            g.setColor(Color.GREEN);
            g.fillRect(chessBoxes[coord[0]][coord[1]][0], chessBoxes[coord[0]][coord[1]][1], 88, 86);
            int[][] arrayOp = getmovePossibility(coordsPiece, coord);
//            System.out.println(arrayOp.length);
            if (arrayOp != null){
                for(int i = 0; i < arrayOp.length; i ++){
                    int x = arrayOp[i][0];
                    int y = arrayOp[i][1];
                    if((x + y)%2 == 0 ){
                        g.setColor(Color.WHITE);
                        g.setColor(new Color(241 - 40,217 - 40,181 - 40));
                    } else {
                        g.setColor(Color.BLACK);
                        g.setColor(new Color(181 - 40,136 - 40,99 - 40));
                    }
                    g.fillRect(chessBoxes[x][y][0], chessBoxes[x][y][1],  88, 86);
                }
            }
        }
    }
    public int[] getChessBox(int x, int y){
        int[] boxCoord = new int[2];
        boxCoord[0] = 29109;
        boxCoord[1] = 29109;
        for(int i = 0; i < chessBoxes.length; i++){
            for(int j = 0; j < chessBoxes[i].length; j++){
                if(x >= chessBoxes[i][j][0] && x <= chessBoxes[i][j][0] + 84 &&
                        chessBoxes[i][j][1] <= y && y <= chessBoxes[i][j][1] + 82){
                    boxCoord[0] = i;
                    boxCoord[1] = j;
                }
            }
        }
        return boxCoord;
    }

    public int[][][] getChessBoxes() {
        return chessBoxes;
    }
}
