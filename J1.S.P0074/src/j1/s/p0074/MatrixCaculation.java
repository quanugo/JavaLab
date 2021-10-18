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
public class MatrixCaculation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validation validator = new Validation();

        boolean check = true;
        while (check) {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = validator.getIntInput("Your choice: ", 1, 4);
            if (choice == 4) {
                System.exit(0);
            }
            processMatrixCaculation(choice);
            System.out.println();
        }
    }
    static void processMatrixCaculation(int option) {
        MatrixHandler processing = new MatrixHandler();
        Validation validator = new Validation();
        int row1 = validator.getIntInput("Enter Row Matrix1: ", 1, Integer.MAX_VALUE);
        int col1 = validator.getIntInput("Enter Column Matrix1: ", 1, Integer.MAX_VALUE);
        int[][] mat1 = processing.newMatrix(row1, col1);
        int row2 = 0, col2 = 0;
        boolean check = true;
        
        while (check) {
            row2 = validator.getIntInput("Enter Row Matrix2: ", 1, Integer.MAX_VALUE);
            if (option != 3) {          
                if (row2 != row1) {
                    System.out.println("Two matrix must be same size!");
                } else {
                    break;
                }
            } else {
                if (row2 != col1) {
                    System.out.println("Matrix2 rows number must equal Matrix1 cols number!");
                } else {
                    break;
                }
            }
        }
        
        while (check) {
            col2 = validator.getIntInput("Enter Column Matrix2: ", 1, Integer.MAX_VALUE);
            if (option != 3) {
                if (col2 != col1) {
                    System.out.println("Two matrix must be same size!");
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        
        int[][] mat2 = processing.newMatrix(row2, col2);
        int[][] result;
        switch (option) {
            case 1: //cộng hai ma trận
                result = new int[row1][col1];
                result = processing.additionMatrix(mat1, mat2);
                processing.displayResult(mat1, mat2, result, option);
                break;
            case 2: //trừ hai ma trận
                result = new int[row1][col1];
                result = processing.subtractionMatrix(mat1, mat2);
                processing.displayResult(mat1, mat2, result, option);
                break;
            case 3: //nhân hai ma trận
                result = new int[row1][col2];
                result = processing.multiplicationMatrix(mat1, mat2);
                processing.displayResult(mat1, mat2, result, option);
                break;
        }
    }
}
