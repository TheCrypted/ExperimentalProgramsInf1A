package com.example.matrixmanipulation;

public class Matrix {
    private int numRows;
    private int numCols;
    private double[][] data;

    public Matrix(int r, int c){
        this.numRows = r;
        this.numCols = c;
        this.data = new double[r][c];
    }
    public Matrix(int r, int c, double[] linArr){
        this.numRows = r;
        this.numCols = c;
        this.data = new double[r][c];
        for(int i = 0; i < r;i++){
            for(int j = 0; j < c; j++){
                assert false;
                this.data[i][j] = linArr[i*c + j];
            }
        }
    }

    public double getElement(int r, int c){
        return data[r][c];
    }

    public void setElement(int r, int c, double value){
        data[r][c] = value;
    }

    public void transpose(){
        int j= this.numCols;
        this.numCols = this.numRows;
        this.numRows = j;
        double[][] transpose = new double[numRows][numCols];
        for(int i = 0; i < this.data.length; i++){
            for(int k = 0; k<this.data[i].length; k++){
                transpose[k][i] = data[i][k];
            }
        }
        this.data = transpose;
    }

    public Matrix multiply(Double scalar){
        Matrix result = this;
        for(int i = 0; i <result.numRows; i++){
            for(int j = 0; j < result.numCols; j++){
                result.data[i][j] *= scalar;
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other){
        if(this.numCols == other.numRows){
            Matrix result = new Matrix(this.numRows, other.numCols);
            for(int i = 0; i <this.numRows; i++){
                for(int k = 0; k < other.numRows; k++) {
                    double sumRow = 0;
                    for (int j = 0; j < this.numCols; j++) {
                        sumRow += this.data[i][j] * other.data[j][k];
                    }
                    result.data[i][k] = sumRow;
                }
            }
            return result;
        }
        return null;
    }

    public String toString() {
        if (data.length == 0) {
            return "Empty matrix";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                sb.append(String.format("%8.3f", data[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public double[][] getData() {
        return data;
    }
}
