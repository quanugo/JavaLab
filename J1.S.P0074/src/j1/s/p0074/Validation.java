package j1.s.p0074;
import java.util.Scanner;

/**
 *
 * @author Quang - HE140675
 */
public class Validation {
    public int getIntInput(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int result = 0;
        while (flag) {
            System.out.print(msg);
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    System.out.println("Out of range");
                    continue;
                }
//                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Number Invalid");
            }
        }
        return result;
    }

}
