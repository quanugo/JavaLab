package J1_S_P0073;

import java.util.ArrayList;

/**
 *
 * @author HE140661
 */
public class ExpenseProgram {

    private static ExpenseManage expenseHandler = new ExpenseManage("handyExpense.txt");

    public static void main(String[] args) {
        DataInputer validator = new DataInputer();
        boolean flag = true;
        while (flag) {    
            displayMenu();
            int choice = validator.getIntInput("Your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    // Add an expense
                    expenseHandler.addExpense(inputNewExpense());
                    System.out.println("");
                    break;
                case 2:
                    // Display all expenses
                    displayAll();
                    System.out.println("");
                    break;
                case 3:
                    // Delete an expense
                    if (expenseHandler.deleteExpense(inputIdDelete())) {
                        System.out.println("Delete an expense successful\n");
                    } else {
                        System.out.println("Delete an expense fail\n");
                    }
                    break;
                case 4:
                    // save to file
                    expenseHandler.saveToFile("handyExpense.txt");
                    // break while loop to exit
                    flag = false;
                    break;
            }
        }
    }
    
    /**Display menu
     * 
     */
    private static void displayMenu(){
        System.out.println("========== Handy Expense Program ==========");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
    }

    // Prompt users input information of the Expense
    private static Expense inputNewExpense() {
        DataInputer validator = new DataInputer();
        System.out.println("\n---------- Add an Expense ----------");
        Expense newExpense = new Expense();
        // Prompt user to input the Date of Expense
        newExpense.setDate(validator.getDateInput("Enter Date: ", "dd-MM-yyyy"));

        // Prompt user to input the amount money of Expense
        newExpense.setAmmount(validator.getIntInput("Enter Amount: ",
                1, Integer.MAX_VALUE));

        // Prompt user to input the Content of Expense
        newExpense.setContent(validator.getStringInput("Enter Content: ",
                "[a-zA-Z ]+"));
        return newExpense;
    }

    /**Display the list of the expenses and total all the inputted expense amount
     * 
     */
    public static void displayAll() {
        ArrayList<Expense> listExpense = expenseHandler.getListExpense();
        System.out.println("\n----------- Display all expenses ----------");
        System.out.format("%-5s%-15s%-10s%-20s\n", "ID", "Date",
                "Amount", "Content");
        for (Expense expense : listExpense) {
            System.out.print(expense.toString());
        }
    }

    /**Prompt users input expense ID of the expense they want to delete
     * 
     * @return id you need delete 
     */
    private static int inputIdDelete() {
        DataInputer validator = new DataInputer();
        System.out.println("----------- Delete an Expense ----------");
        // Get ID
        int idDelete = validator.getIntInput("Enter ID: ",
                Integer.MIN_VALUE, Integer.MAX_VALUE);
        return idDelete;
    }
}
