
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MacBook
 */
public class DataInput {

    private static Scanner scanner = new Scanner(System.in);

    //Check input number
    public static int inputIntNumber(String sMess, int iMin, int iMax) {
        int iValue;
        System.out.println(sMess);
        while (true) {
            try {
                iValue = Integer.parseInt(scanner.nextLine());
                if (iValue < iMin || iValue > iMax) {
                    throw new NumberFormatException();
                }
                return iValue;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter again: ");
            }
        }
    }

    //Check input time from
    public static double inputTimeFrom(String sMess, double dMin, double dMax) {
        double timeFrom = 0;
        System.out.println(sMess);
        while (true) {
            try {
                timeFrom = Double.parseDouble(scanner.nextLine());
                if (timeFrom < dMin && timeFrom > dMax || timeFrom % 0.5 != 0) {
                    throw new NumberFormatException();
                }
                return timeFrom;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter again: ");
            }
        }
    }

    //Check input time to
    public static double inputTimeTo(String sMess, double dMin, double dMax) {
        double timeTo = 0;
        System.out.println(sMess);
        while (true) {
            try {
                timeTo = Double.parseDouble(scanner.nextLine());
                if (timeTo < dMin || timeTo > dMax || timeTo % 0.5 != 0) {
                    throw new NumberFormatException();
                }
                return timeTo;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter again: ");
            }
        }
    }

    //Check input task type
    public static int inputTaskType(String sMess, int iMin, int iMax) {
        int taskType = 0;
        System.out.println(sMess);
        while (true) {
            try {
                taskType = Integer.parseInt(scanner.nextLine());
                if (taskType < iMin || taskType > iMax) {
                    throw new NumberFormatException();
                }
                return taskType;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter again: ");
            }
        }
    }

    //Check String
    public static String inputString(String sMess) {
        String s;
        System.out.println(sMess);
        while (true) {
            try {
                s = scanner.nextLine().trim();
                if (s.isEmpty()) {
                    throw new Exception(sMess + "is empty");
                }
                return s;
            } catch (Exception e) {
                System.out.println("Enter again: ");
            }
        }
    }

    
    //Check input date
    public static String inputDate(){
        String sDate;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        while (true) {            
            try {
                System.out.println("Enter Date: ");
                sDate = scanner.nextLine().trim();
                Date dDate = sdf.parse(sDate);
                Date dPresent = new Date();
                
                if(dDate.after(dPresent)){
                    throw new Exception();
                }
                return sdf.format(dDate);
            } catch (Exception e) {
                System.out.println("Enter Date again: ");
            }
        }
    }
}
