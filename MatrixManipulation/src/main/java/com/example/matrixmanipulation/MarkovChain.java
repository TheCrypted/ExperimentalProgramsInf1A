package com.example.matrixmanipulation;

public class MarkovChain {
    private Vector sVector;
    private Matrix tMatrix;

    public MarkovChain(Vector sVector, Matrix tMatrix) {
        this.sVector = sVector;
        this.tMatrix = tMatrix;
    }
    public boolean isValid() {
        if (sVector.getNumCols() != tMatrix.getNumRows() ||
                tMatrix.getNumRows() != tMatrix.getNumCols()) {
            return false;
        }
        // check that state vector sums to 1
        double sum = 0;
        for (int i = 0; i < sVector.getNumCols(); i++) {
            sum += sVector.getElement(i);
        }
        if (Math.abs(sum - 1) > 0.0001) {
            return false;
        }
        // check that each row in transition matrix sums to 1
        for (int i = 0; i < tMatrix.getNumRows(); i++) {
            sum = 0;
            for (int j = 0; j < tMatrix.getNumCols(); j++) {
                sum += tMatrix.getElement(i, j);
            }
            if (Math.abs(sum - 1) > 0.0001) {
                return false;
            }
        }
        return true;
    }
//
    public Matrix computeProbabilityMatrix(int numSteps) {
        if (!isValid()) {
            return null;
        }
        Matrix result = tMatrix;
        for (int i = 1; i < numSteps; i++) {
            result = result.multiply(tMatrix);
        }
        return sVector.multiply(result);
    }

}

