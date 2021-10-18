package J1_S_P0073;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author HE140661
 */
public class DataInputer {

    /**
     * Get number the user input from keyboard
     * @param msg Message
     * @param min range min
     * @param max range max
     * @return intInput
     */
    public int getIntInput(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int intInput = 0;
        // loop until the uster input with the right form
        while (flag) {
            System.out.print(msg);
            try {
                intInput = Integer.parseInt(sc.nextLine());
                if (intInput < min || intInput > max) {
                    System.out.println("Out of range");
                    continue;
                }
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Number invalid");
            }
        }
        return intInput;
    }

    /**
     * Get string the user input from the keyboard
     * @param msg Message
     * @param regex Format of string
     * @return stringInput
     */
    public String getStringInput(String msg, String regex) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String stringInput = "";
        while (flag) {
            System.out.print(msg);
            stringInput = sc.nextLine().trim();
            if (stringInput.isEmpty()) {
                System.out.println("Not empty");
                continue;
            }
            if (!stringInput.matches(regex)) {
                System.out.println("Content invalid");
                continue;
            }
            flag = false;
        }
        return stringInput;
    }

    /**
     * Get date the user input from the keyboard
     * @param msg Message
     * @param format Format of date
     * @return dateInput
     */
    public Date getDateInput(String msg, String format) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        // turn of the Leniency mode
        dateFormat.setLenient(false);
        Date dateInput = null;
        Date now;
        boolean flag = true;
        while (flag) {
            System.out.print(msg);
            try {
                dateInput = dateFormat.parse(sc.nextLine());
                now = new Date();
                // ask the user to re-enter the date if it has not yey arrived
                if (dateInput.after(now)) {
                    System.out.println("This date not exists");
                    continue;
                } else {
                }
                flag = false;
            } catch (ParseException e) {
                System.out.println("Date invalid");
            }
        }
        return dateInput;
    }
    
    /**
     * Convert string to date
     * @param str
     * @return date
     */
    public Date convertStringToDate(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(str);
        } catch (Exception e) {
            System.out.println("Date invalid");
        }
        return date;
    }
}
