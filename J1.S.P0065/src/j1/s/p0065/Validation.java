/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0065;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Validation {
    public String getStringInput(){
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        String result = "";
        while(check){
            result = sc.nextLine().trim();
            //nếu String rỗng yêu cầu nhập lại
            if(result.isEmpty()){
                System.out.println("You must input data");
            }else{
                return result;
                }
        }
        return result;
    }
    
    public double getDoubleInput(String mess) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mess);
        boolean check = true;
        double number = 0;    
        while(check) {
            String input = sc.nextLine();
            try {
                number = Double.parseDouble(input);
                if(number < 0 || number > 10){
                    System.out.println(mess + " is between 0 and 10");
                    System.out.println("re-input: ");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) { 
                System.out.print("Please input an double number: ");
            }
        }
        return number;
    }
    
    public boolean checkYesNo(){
        boolean check = true;
        String result = "";
        while(check){
            result = getStringInput();
            if(result.length()==1){
                char resultChar = result.charAt(0);
                if(resultChar == 'y' || resultChar == 'Y'){
                    return true;
                }
                if(resultChar == 'n' || resultChar == 'N'){
                    return false;
                }
            }
            System.out.println("Re-input");
        }
        return false;
    }    
}