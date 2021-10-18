package LoginBank;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Quang - HE140675
 */
public class BankApp {
    
    public static void main(String[] args) {
        DataInput dataInputer = new DataInput();
        boolean check = true;
        while (check) {
            displayMenu();
            int input = dataInputer.getIntInput("Please choose one option: ", 1, 3);
            switch (input) {
                case 1:
                    //Vietnamese language              
                    ResourceBundle viBundle = ResourceBundle.getBundle("Language//language_vi");
                    loginSytem(viBundle);
                    break;
                case 2:
                    //English language
                    ResourceBundle enBundle = ResourceBundle.getBundle("Language//language_en");
                    loginSytem(enBundle);
                    break;
                case 3:
                    return;
            }
        }
    }
    
    // Show menu to user choice
    public static void displayMenu() {
        System.out.println("=========Login Tien Phong Bank’s Ebank===========");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }

    // Login with infomation from user
    public static void loginSytem(ResourceBundle bundle) {
        getAccountNumber(bundle);
        getPassword(bundle);
        getCaptcha(bundle);
    }
    
    // Input account
    public static void getAccountNumber(ResourceBundle bundle) {
        Scanner scan = new Scanner(System.in);
        BankHandler handler = new BankHandler();
        boolean check = true;
        while (check) {
            System.out.print(bundle.getString("account"));
            String accountNumber = scan.nextLine();
            if (handler.checkAccNumber(accountNumber)) {
                check = false;
            } else {
                System.out.println(bundle.getString("check.account"));
            }
        }
    }
    
    // Input Password
    public static void getPassword(ResourceBundle bundle) {
        Scanner scan = new Scanner(System.in);
        BankHandler handler = new BankHandler();
        boolean checkLoop = true;
        while (checkLoop) {
            System.out.print(bundle.getString("password"));
            String password = scan.nextLine();
            if (handler.checkPassword(password)) {
                return;
            } else {
                System.out.println(bundle.getString("wrong.password"));
            }
        }
    }
    
    // Input Captcha
    public static void getCaptcha(ResourceBundle bundle) {
        Scanner scan = new Scanner(System.in);
        BankHandler handler = new BankHandler();
        //Random captcha
        String captcha = handler.randomCaptcha();
        System.out.println(bundle.getString("captcha") + captcha);
        boolean checkCapt = true;
        while (checkCapt) {
            //Input captcha
            System.out.print(bundle.getString("captchaInput"));
            String input = scan.nextLine();
            if (input.equals(captcha)) {
                System.out.println(bundle.getString("Login-successfully"));
                return;
            } else {
                System.out.println(bundle.getString("wrong.captcha"));
                captcha = handler.randomCaptcha();
                System.out.println(bundle.getString("captcha") + captcha);
            }
        }
    }
}
