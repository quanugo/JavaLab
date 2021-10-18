package j1.s.p0050;

/**
 *
 * @author Quang - HE140675
 */
public class Main {
    public static void main(String[] args) {
        boolean check = true;
        EquationHandler processing = new EquationHandler();
        while (check) {
            int choice = menu();
            switch (choice) {
                case 1:
                    processing.superlativeEquation();
                    break;
                case 2:
                    processing.quadraticEquation();
                    break;
                case 3:
                    return;
            }
        }
    }
    
    public static int menu() {
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
  
        int choice = Validation.getChoiceInput("Your choice: ", 1, 3);
        return choice;
    }
}
