package LoginBank;

import java.util.Scanner;

/**
 *
 * @author dell
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
}
