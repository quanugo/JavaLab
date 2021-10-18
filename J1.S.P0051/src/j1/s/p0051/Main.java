/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0051;

/**
 *
 * @author Quang - He140675
 */
public class Main {
    public static void main(String[] args) {
        Validation validator = new Validation();
        BMICalculation processing = new BMICalculation();
        boolean check = true;
        while (check) {
            int choice = menu();
            switch (choice) {
                case 1:
                    normalCalculator();
                    break;
                case 2:
                    System.out.println("----- BMI Calculator -----");
                    double weight = validator.getDoubleInput("Enter Weight(kg): ");
                    double height = validator.getDoubleInput("Enter Height(cm): ");
                    System.out.printf("BMI Number: %.2f\n", processing.calculateBMI(weight, height));
                    System.out.println("BMI Status: " + processing.bmiStatus(processing.calculateBMI(weight, height)));
                    break;
                case 3:
                    return;
            }
        }
    }
    
    static int menu() {
        Validation validator = new Validation();
        System.out.println("======Calculator Program======");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        int choice = validator.getChoiceInput("Your choice :", 1, 3);
        return choice;
    }
    
    static double inputNumber() {
        Validation validator = new Validation();
        double number = validator.getDoubleInput("Enter number: ");
        return number;
    }
    
    static void normalCalculator() {
        double memory;
        Validation validator = new Validation();
        memory = validator.getDoubleInput("Enter number: ");
        boolean check = true;
        while (check) {
            String operator = validator.getInputOperator("Enter operator: ");
            if (operator.equalsIgnoreCase("+")) {
                memory += inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                memory -= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                memory *= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
                while (true) {                    
                double a = inputNumber();
                if(a==0){
                    System.out.println("Please Re-Enter divisor!!!");
                }
                else{
                    memory /= a;                   
                    System.out.println("Memory: " + memory);
                    break;
                }               
                }
            }
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, inputNumber());
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }
    }
}
