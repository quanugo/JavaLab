
package j1.s.p0071;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author dell
 */
public class Main {
    private static TaskHandler handleTask = new TaskHandler();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataInput dataInputer = new DataInput();
        boolean check = true;
        while (check) {
            System.out.println("========= Task program =========");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            int choice = dataInputer.getIntInput("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1:
                    handleTask.addTask(inputTask());
                    break;
                case 2:
                    int id = dataInputer.getIntInput("Enter ID: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    if(handleTask.deleteTask(id) == 0){
                        System.out.println("List empty!!");
                    }
                    if(handleTask.deleteTask(id) == 1){
                        System.out.println("Delete successfully\n");
                    }
                    if(handleTask.deleteTask(id) == -1){
                        System.out.println("ID doesn't exist\n");
                    }
                    break;
                case 3:
                    showDataTasks();
                    break;
                case 4:
                    check = false;
                    break;
            }
        }
    }
    
    static final HashMap<Integer, String> taskTile = new HashMap<Integer, String>() {
        {
            put(1, "Code");
            put(2, "Test");
            put(3, "Design");
            put(4, "Review");
        }
    };
    
    public static String getTaskType(String msg) {
        DataInput dataInputer = new DataInput();
        int type = dataInputer.getIntInput(msg, 1, 4);
        return taskTile.get(type);
    }
    
    private static Task inputTask(){
        DataInput dataInputer = new DataInput();
        int id = 1;
        if (!handleTask.getListTask().isEmpty()) {
            int lastIndex = handleTask.getListTask().size() - 1;
            id = handleTask.getListTask().get(lastIndex).getId() + 1;
        }
        
        Task objTask = new Task();
        System.out.println("\n------------ Add Task ------------");
        objTask.setName(dataInputer.getStringInput("Requirement Name: ", "[a-zA-Z ]+"));
        objTask.setTaskType(getTaskType("Task type "));
        objTask.setDate(dataInputer.checkDateInput("Date ", "dd/MM/yyyy"));
        objTask.setFrom(dataInputer.getDoubleInput("From "));
        objTask.setTo(dataInputer.getDoubleInput("To "));
        boolean check = true;
        while (check) {
            if (objTask.getFrom() < objTask.getTo()) {
                check = false;
            } else {
                System.out.println("To must greater than ");
                objTask.setTo(dataInputer.getDoubleInput("To"));
            }
        }
        objTask.setAssignee(dataInputer.getStringInput("Assignee: ", "[a-zA-Z ]+"));
        objTask.setReviewer(dataInputer.getStringInput("Reviewer: ", "[a-zA-Z ]+"));
        
        return objTask;
    }
    
    public static void showDataTasks() {
        if (handleTask.getListTask().isEmpty()) {
            System.out.println("\nList empty\n");
            return;
        }
        System.out.println("\n------------------------------------------ Task ----------------------------------------");
        System.out.format("%-5s%-20s%-15s%-15s%-10s%-15s%-15s\n",
                "ID", "Name",
                "Task Type", "Date",
                "Time", "Assignee",
                "Reviewer");
        for (Task task : handleTask.getListTask()) {
            System.out.print(task.toString());
        }
        System.out.println("");
    }
    
    
}
