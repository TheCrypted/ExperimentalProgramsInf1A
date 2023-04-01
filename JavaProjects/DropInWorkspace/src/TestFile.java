import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestFile{
    public static boolean isVowel(char test){
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        for (char vowel : vowels) {
            if (test == vowel)
                return true;
        }
        return false;
    }
    public static char middleChar(String test) {
        if (test.length() % 2 != 0){
            return test.charAt((test.length() + 1) / 2 - 1);
        }
        return (char)(((int)test.charAt(test.length() / 2 - 1) + (int)test.charAt(test.length() / 2))/2);
    }
    public static void countdown(String[] initTime){
        int[] input = new int[2];
        for(int i = 0; i < initTime.length; i++){
            input[i] = Integer.parseInt(initTime[i]);
        }
        boolean test = false;
        int store = input[0];
        for(int i = input[0]; i >= 0; i--){
            if(store != i){
                test = true;
            }
            int counter = i == input[0] ? input[1] : 60;
            for(int j = counter; j >= 0 ; j--){
                if(j == 60){
                    store = i;
                }
                if(!test) {
                    System.out.printf(" %s : %2.0f %n", i, (float) j);
                }
                test = false;
            }
        }
    }
    public static boolean isStrong(String input){
        for(int i=0; i<input.length()-1; i++){
            if(!isVowel(input.charAt(i))){
                if(!isVowel(input.charAt(i+1))){
                    return false;
                }
            }
        }
        return true;
    }
    public static Object[] dropSort(String[] input){
        int[] inputInt = new int[input.length];
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i < input.length; i++){
            inputInt[i] = Integer.parseInt(input[i]);
        }
        int max = inputInt[0];
        for(int i = 0; i< inputInt.length;i++){
            if(inputInt[i] >= max){
                max = inputInt[i];
            } else {
                inputInt[i] = 0;
            }
        }
        for (int j : inputInt) {
            if (j != 0) {
                output.add(j);
            }
        }
        return output.toArray();
    }
    public static String convertAcronym(String  alpha){
        String[] beta = alpha.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : beta){
            String check = word.toLowerCase();
            if(!check.equals("and") && !check.equals("or") && !check.equals("by") && !check.equals("of")){
                sb.append(word.toUpperCase().charAt(0));
            }
        }
        return sb.toString();
    }

    public static boolean isBetween(char a, char[] range) {
        return range[0] < a && a < range[1];
    }
    public static boolean isHigher(char[] range){
        return (int) range[0] >= range[1];
    }
    public static void timeAfter(String input){
        String[] time = input.split("[hms]");
        System.out.println((Integer.parseInt(time[0])%24 + Integer.parseInt(time[1])/60) + " : " + (Integer.parseInt(time[1])%60 + Integer.parseInt(time[2])/60) + " : " + Integer.parseInt(time[2])%60);
    }
    public static boolean isCircular(String input) {
        char[][] ranges = new char[input.length()-1][2];
        for(int i = 0; i +1 < input.length(); i++) {
            ranges[i][0] = input.charAt(i);
            ranges[i][1] = input.charAt(i+1);
        }
//        System.out.println(Arrays.deepToString(ranges));
        for(int i = 1; i +2 < input.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(isBetween(input.charAt(i+2), ranges[j])){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter word: ");
        String input = scan.nextLine();
//        String[] inputUsable = input.split(" ");
        System.out.println(isStrong(input));

//        System.out.println(Arrays.toString(dropSort(inputUsable)));
//        System.out.println(isStrong(input.toLowerCase()));
//        System.out.println(middleChar(input.toLowerCase()));


//        LinkedList<Integer> newList = new LinkedList<>();
//        for(int i = 0; i < 10; i++){
//            newList.addFront(i+1);
//        }
//        newList.removeFront();
//        for(int i : newList){
//            System.out.println(i);
//        }
    }
}




//import java.awt.*;
//        import java.awt.geom.Point2D;
//        import java.util.Random;
//
//public class TestFile {
//    private static Random random;
//    public static double pointDist(Point2D x, Point2D y) {
//        return Math.sqrt(Math.pow(x.getX() - y.getX(), 2) + Math.pow(x.getY() - y.getY(), 2));
//    }
//    public static int findClosestPoint(Point2D x, Point2D[] sites){
//        int closestPoint = 0;
//        for(int i = 1; i < sites.length; i++){
//            if(pointDist(x, sites[i]) < pointDist(x, sites[closestPoint])){
//                closestPoint = i;
//            }
//        }
//        return closestPoint;
//    }
//    public static int[][] buildVoronoiMap(Point2D[] sites, int width, int height){
//        int[][] voronoiMap = new int[height][width];
//        for(int i = 0; i < voronoiMap.length; i++){
//            for(int j = 0; j < voronoiMap[i].length; j++){
//                Point2D current = new Point2D.Double(i, j);
//                voronoiMap[i][j] = findClosestPoint(current, sites);
//            }
//        }
//        return voronoiMap;
//    }
//    public static void plotVoronoiMap(Point2D[] sites, int[][] voronoiMap, Color[] colors){
//        int width = voronoiMap[0].length;
//        int height = voronoiMap.length;
//        StdDraw.setCanvasSize(width, height);
//        StdDraw.setXscale(0, width);
//        StdDraw.setYscale(0, height);
//        for(int i = 0; i<voronoiMap.length;i++){
//            for(int j = 0; j< voronoiMap[i].length;j++){
//                StdDraw.setPenColor(colors[voronoiMap[i][j]]);
//                StdDraw.point(i, j);
//            }
//        }
//        for (Point2D site : sites) {
//            StdDraw.setPenColor(new Color(0, 0, 0));
//            StdDraw.filledCircle(site.getX(), site.getY(), 3);
//        }
//    }
//
//
//    public static void main(String[] args) {
//        Random random = new Random();
//        int width = 400;
//        int height = 400;
//        int nSites = 30;
//        Point2D[] sites = new Point2D[nSites];
//        for(int i = 0; i < nSites; i++){
//            sites[i] = new Point2D.Double(random.nextDouble(width), random.nextDouble(height));
//        }
//        Color[] colors = new Color[nSites];
//        for(int i = 0; i < nSites; i++){
//            colors[i] = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
//        }
//        int[][] indexmap = buildVoronoiMap(sites, width, height);
//        plotVoronoiMap(sites, indexmap, colors);
//
//
//    }
//}