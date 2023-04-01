package Constants;
import java.util.Arrays;
import java.util.Arrays.*;
public class ChessPieces {
    private int[] coord;

    public ChessPieces(int[] coord){
        this.coord = coord;
    }

//    public static boolean anotherPieces(int[] coord){
//
//    }

    public static int[][] getMoveRook(int[] boxCoord){
        int blocksInX = 7-boxCoord[0];
        int blocksInNegX = boxCoord[0];
        int blocksInY = 7-boxCoord[1];
        int blocksInNegY = boxCoord[1];
        int totalMovableBlocks = blocksInNegX+blocksInNegY+blocksInX+blocksInY;

        int[][] coordinates = new int[totalMovableBlocks][2];
    //        System.out.println(blocksInX);
            for (int i = 0; i < blocksInY; i++) {
                coordinates[i][0] = boxCoord[0];
                coordinates[i][1] = boxCoord[1] + i + 1;
            }
            for (int i = 0; i < blocksInX; i++) {
                coordinates[blocksInY + i][0] = boxCoord[0] + i + 1;
                coordinates[blocksInY + i][1] = boxCoord[1];
            }
            for (int i = 0; i < blocksInNegX; i++) {
                coordinates[blocksInY + blocksInX + i][0] = boxCoord[0] - i - 1;
                coordinates[blocksInY + blocksInX + i][1] = boxCoord[1];
            }
            for (int i = 0; i < blocksInNegY; i++) {
                coordinates[blocksInY + blocksInX + blocksInNegX + i][0] = boxCoord[0];
                coordinates[blocksInY + blocksInX + blocksInNegX + i][1] = boxCoord[1]- i - 1;
            }
        return coordinates;
    }
    public static int[][] getMoveKing(int[] boxCoord){
        int[][] moveFront = {{-1,1}, {-1,-1}, {1,1}, {1,-1}, {1,0}, {-1,0}, {0,1}, {0,-1}};
        return getInts(boxCoord, moveFront);

    }

    private static int[][] getInts(int[] boxCoord, int[][] moveFront) {
        int[][] possibleAdditions = new int[8][2];
        int totalMovableBlocks = 0;
        int j = 0;
        for(int i = 0; i < possibleAdditions.length; i++){
            possibleAdditions[i][0] = 21091;
            possibleAdditions[i][1] = 21091;
        }
        for (int[] ints : moveFront) {
            int x = ints[0];
            int y = ints[1];
            if (boxCoord[0] + x >= 0 && boxCoord[1] + y >= 0 && boxCoord[0] + x < 8 && boxCoord[1] + y < 8) {
                possibleAdditions[j][0] = boxCoord[0] + x;
                possibleAdditions[j][1] = boxCoord[1] + y;
                j++;
                totalMovableBlocks++;
            }
        }
        int[][] coordinates = new int[totalMovableBlocks][2];
        for(int i = 0; i < possibleAdditions.length; i++){
            if(possibleAdditions[i][0] != 21091 && possibleAdditions[i][1] != 21091){
                coordinates[i][0] = possibleAdditions[i][0];
                coordinates[i][1] = possibleAdditions[i][1];
            }
        }
        return coordinates;
    }

    public static int[][] getMoveKnight(int[] boxCoord){
        int[][] moveFront = {{-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}};
        return getInts(boxCoord, moveFront);
    }

    public static int[][] getMoveQueen(int[] boxCoord){
        int[][] xyDiag = ChessPieces.getMoveBishop(boxCoord);
        int[][] xy = ChessPieces.getMoveRook(boxCoord);
        int[][] coordinates = new int[xy.length + xyDiag.length][2];
        System.arraycopy(xyDiag, 0, coordinates, 0, xyDiag.length);
        System.arraycopy(xy, 0, coordinates, xyDiag.length, xy.length);
        return coordinates;
    }

    public static int[][] getMoveBishop(int[] boxCoord){
        int downRight = Math.min(7 - boxCoord[0], 7 - boxCoord[1]);
        int downLeft = Math.min(boxCoord[0], 7 - boxCoord[1]);
        int upLeft = Math.min(boxCoord[0], boxCoord[1]);
        int upRight = Math.min(7 - boxCoord[0], boxCoord[1]);
        int totalMovableBlocks = downLeft + downRight + upRight + upLeft;
        int[][] coordinates = new int[totalMovableBlocks][2];
        for(int i = 0; i < downRight; i++){
            for(int j = 0; j < 2; j++){
                coordinates[i][j] = boxCoord[j] + i + 1;
            }
        }
        for(int i = 0; i < upLeft; i++){
            for(int j = 0; j < 2; j++){
                coordinates[downRight + i][j] = boxCoord[j] - i - 1;
            }
        }
        for(int i = 0; i < downLeft; i++){
            coordinates[upLeft + downRight + i ][0] = boxCoord[0] - i - 1;
            coordinates[upLeft + downRight + i ][1] = boxCoord[1] + i + 1;
        }
        for(int i = 0; i < upRight; i++){
            coordinates[upLeft + downRight + downLeft + i ][0] = boxCoord[0] + i + 1;
            coordinates[upLeft + downRight + downLeft + i ][1] = boxCoord[1] - i - 1;
        }
        return coordinates;
    }
}
