/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0050;

import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Validation {
    
    public static int getChoiceInput(String msg, int min, int max) {
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
    public static double getDoubleInput(String mess) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mess);
        boolean check = true;
        double number = 0;    
        while(check) {
            String input = sc.nextLine();
            try {
                number = Double.parseDouble(input);
                return number;
            } catch (Exception e) { 
                System.out.print("Please input an double number: ");
            }
        }
        return number;
    }

    public static boolean checkOdd(double n) {
        if (n % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    
    public static boolean checkEven(double n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkSquareNumber(double n) {
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return true;
        } else {
            return false;
        }
    }
}
