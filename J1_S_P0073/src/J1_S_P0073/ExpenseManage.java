package J1_S_P0073;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author HE140661
 */
public class ExpenseManage {

    private ArrayList<Expense> listExpense;

    private int maxExpenseID = 0;

    public ExpenseManage(String pathFile) {
        listExpense = new ArrayList<>();
        DataInputer validator = new DataInputer();
        Scanner sc = null;
        try {
            sc = new Scanner(Paths.get(pathFile));
        } catch (Exception e) {
            System.out.println("File not found");
            return;
        }
        // loop until the file has next line
        while (sc.hasNextLine()) {
            String lineData = sc.nextLine().trim();
            // split string
            String[] lineDataArray = lineData.split(" ");
            System.out.println(Arrays.toString(lineDataArray));
            if (lineDataArray.length == 1) {
                maxExpenseID = Integer.valueOf(lineDataArray[0]);
            } else {
                Expense objExpense = new Expense();
                objExpense.setId(Integer.valueOf(lineDataArray[0]));
                objExpense.setDate(validator.convertStringToDate(lineDataArray[1]));
                objExpense.setAmmount(Integer.valueOf(lineDataArray[2]));
                String content = "";
                for (int i = 3; i < lineDataArray.length; i++) {
                    content = lineDataArray[i] + " " + content;
                }
                objExpense.setContent(content);
                listExpense.add(objExpense);
            }
        }
        sc.close();
    }

    void saveToFile(String pathFile) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            PrintWriter print = new PrintWriter(pathFile);
            print.println(maxExpenseID);
            for (Expense expense : listExpense) {
                print.println(expense.getId() + " "
                        + dateFormat.format(expense.getDate()) + " "
                        + expense.getAmmount() + " " + expense.getContent());
            }
            print.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

    public ArrayList<Expense> getListExpense() {
        return listExpense;
    }

    // Get ID of Expense
    public int autoIncreaseID() {
        if (maxExpenseID >0) {
            return ++maxExpenseID;
        } else {
            // if ArrayList is empty then frist id is 1
            if (listExpense.isEmpty()) {
                maxExpenseID = 1;
                return maxExpenseID;
            }
            // get last expense ID
            maxExpenseID = listExpense.get(listExpense.size() - 1).getId();
            return ++maxExpenseID;
        }
    }

    /**
     * Add new Expense into ArrayList
     * @param objExpense
     */
    public boolean addExpense(Expense objExpense) {
        int id = autoIncreaseID();
        objExpense.setId(id);
        listExpense.add(objExpense);
        saveToFile("handyExpense.txt");
        return true;
    }

    /**
     * Delete an expense
     * @param idDelete
     * @return
     */
    public boolean deleteExpense(int idDelete) {
        // Get index of ID that user want to delete
        int index = getIndexExpense(idDelete);

        // If ID existed, delete and display on the screen :”Delete an expense successful”
        if (index != -1) {
            // get max expense id
            maxExpenseID = listExpense.get(listExpense.size() - 1).getId();
            // remore expense from ArrayList
            listExpense.remove(index);
            saveToFile("handyExpense.txt");
            return true;
        }
        return false;
    }

    /**
     * Get index of Task that user want to delete
     * @param id
     * @return
     */
    public int getIndexExpense(int id) {
        for (int i = 0; i < listExpense.size(); i++) {
            if (listExpense.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
