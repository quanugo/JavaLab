/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

/**
 *
 * @author dell
 */
public class MatrixHandler {
    Validation validator = new Validation();
    
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] newMat = new int[matrix1.length][matrix1[0].length];
        //i chạy từ vị trí đầu hàng đến cuối hàng ma trận
        for (int i = 0; i < matrix1.length; i++) {
            //j chạy từ đầu cột đến cuối cột của ma trận
            for (int j = 0; j < matrix1[0].length; j++) {
                newMat[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return newMat;
    }
    
    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] newMat = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                newMat[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return newMat;
    }
    
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] newMat = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    newMat[i][j] = newMat[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return newMat;
    }
    
    void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
    
    int[][] newMatrix(int row, int col) {
        Validation validator = new Validation();
        int[][] newMat = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newMat[i][j] = validator.getIntInput(String.format("Enter Matrix[%d][%d]: ", i+1, j+1), Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return newMat;
    }
    
    void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, int option) {
        System.out.println("--------- Result ---------");
        displayMatrix(matrix1);
        switch (option) {
            case 1:
                System.out.println("+");
                break;
            case 2: 
                System.out.println("-");
                break;
            case 3:
                System.out.println("*");
                break;
        }
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

}
