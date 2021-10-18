package LoginBank;

import java.util.Random;

/**
 *
 * @author dell
 */
public class BankHandler {
    
    // Random Captcha to login
    public String randomCaptcha() {
        String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        String captcha = "";
        //Random 5 characters captcha
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(s.length());
            captcha = captcha + s.charAt(index);
        }
        return captcha;
    }
    
    // Check format acountnumber
    public boolean checkAccNumber(String accountNumber) {
        return accountNumber.matches("^[0-9]{10}$");
    }
    
    // Check format password
    public boolean checkPassword(String password) {
        return password.matches("^(?=.*?[A-Za-z])(?=.*?[0-9]).{8,31}");
    }
    
}
