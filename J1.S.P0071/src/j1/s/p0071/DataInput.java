package j1.s.p0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Quang - HE140675
 */

public class DataInput {
    
    public int getIntInput(String msg, int min, int max) {
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
    
    public String getStringInput(String msg, String format) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        String str = "";
        while (check) {
            System.out.print(msg);
            str = sc.nextLine().trim();
            if (str.isEmpty()) {
                System.out.println("Not empty");
                continue;
            }
            if (!str.matches(format)) {
                System.out.println("Content Invalid");
                continue;
            }
            check = false;
        }
        return str;
    }

    public Date checkDateInput(String msg, String format) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        boolean check = true;
        Date date = null;
        Date now = new Date();
        while (check) {
            System.out.print(msg);
            try {
                date = dateFormat.parse(sc.nextLine());
                if (date.after(now)) {
                    System.out.println("This date doesn't exists");
                    continue;
                }
                check = false;
            } catch (ParseException e) {
                System.out.println("Date Invalid");
            }
        }
        return date;
    }

    public double getDoubleInput(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        double number = 0;
        while (check) {
            System.out.print(msg);
            try {
                number = Double.parseDouble(sc.nextLine());
                // time must from 8 to 17.5
                if (number >= 8.0 && number <= 17.5 && number % 0.5 == 0) {
                    check = false;
                } else {
                    System.out.println("Time must [8.0 - 17.5]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Time invalid");
            }
        }
        return number;
    }
}
