package Levels;

public class levelA {
    private int[][] lvlData;
    public levelA(int[][] lvlData) {

        this.lvlData = lvlData;
    }
    public int getSpriteIndex(int x, int y) {

        return lvlData[y][x];
    }
    public int[][] getLvlData(){
        return lvlData;
    }
}
