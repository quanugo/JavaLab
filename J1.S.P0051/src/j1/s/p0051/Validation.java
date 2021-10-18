/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0051;
import java.util.Scanner;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author dell
 */
public class Validation {
    public int getChoiceInput(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int result = 0;
        while (check) {
            System.out.print(msg);
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    System.out.println("Out of range");
                    continue;
                }
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Number Invalid");
            }
        }
        return result;
    }
    
     //Enter double input
    public double getDoubleInput(String mess) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mess);
        boolean check = true;
        double number = 0;    
        while(check) {
            String input = sc.nextLine();
            try {
                number = Double.parseDouble(input);
                return number;
            } catch (NumberFormatException e) { 
                System.out.print("Please input an double number: ");
            }
        }
        return number;
    }
    
    public String getInputOperator(String mess) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mess);
        boolean check = true;
        String result = "";
        while (check) {
            result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else if (result.equalsIgnoreCase("+") || result.equalsIgnoreCase("-")
                    || result.equalsIgnoreCase("*") || result.equalsIgnoreCase("/")
                    || result.equalsIgnoreCase("^") || result.equalsIgnoreCase("=")) {
                return result;
            } else {
                System.err.println("Please input (+, -, *, /, ^)");
            }
            System.out.print("Enter again: ");
        }
        return result;
    }
}
