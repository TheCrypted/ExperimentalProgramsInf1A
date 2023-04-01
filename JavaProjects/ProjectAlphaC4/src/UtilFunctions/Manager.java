package UtilFunctions;

public class Manager {
    public static int checkWin(int[][] colorArray){
        //CHECK HORIZONTAL
        for(int i=0; i<colorArray.length; i++){
            for (int j= 0; j< colorArray[i].length; j++){
                if(j+3 < colorArray[i].length){
                    if(colorArray[i][j] == colorArray[i][j+1]&& colorArray[i][j+2]== colorArray[i][j+3]
                            && colorArray[i][j+1] == colorArray[i][j+2] && colorArray[i][j] != 3){
                        return colorArray[i][j];
                    }
                }
            }
        }

        // CHECK VERTICAL
        for(int i=0; i<colorArray.length; i++){
            for (int j= 0; j< colorArray[i].length; j++){
                if(i+3 < colorArray.length){
                    if(colorArray[i][j] == colorArray[i+1][j]&& colorArray[i+2][j]== colorArray[i+3][j]
                            && colorArray[i+2][j] == colorArray[i+1][j] && colorArray[i][j] != 3){
                        return colorArray[i][j];
                    }
                }
            }
        }
        // CHECK DIAGONAL FORWARD
        for(int i=0; i<colorArray.length; i++){
            for (int j= 0; j< colorArray[i].length; j++){
                if(j+3 < colorArray[i].length && i +3 < colorArray.length){
                    if(colorArray[i][j] == colorArray[i+1][j+1]&& colorArray[i+2][j+2]== colorArray[i+3][j+3]
                            && colorArray[i+1][j+1] == colorArray[i+2][j+2] && colorArray[i][j] != 3){
                        return colorArray[i][j];
                    }
                }
            }
        }
        // CHECK DIAGONAL BACKWARD
        for(int i=0; i<colorArray.length; i++){
            for (int j= 0; j< colorArray[i].length; j++){
                if(j+3 < colorArray[i].length && i - 3 >= 0){
                    if(colorArray[i][j] == colorArray[i-1][j+1]&& colorArray[i-2][j+2]== colorArray[i-3][j+3]
                            && colorArray[i-1][j+1] == colorArray[i-2][j+2] && colorArray[i][j] != 3){
                        return colorArray[i][j];
                    }
                }
            }
        }
    return 21091;

    }
}
