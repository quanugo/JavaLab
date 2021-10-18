/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MacBook
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    TaskManager taskManager = new TaskManager();
    
    private static void displayMenu(){
            System.out.println("====== Task Manager ======");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
    }
    
    public void addTask(){
        System.out.println("------ Add Task ------");
        if(taskManager.addTask(TaskView.inputTask())){
            System.out.println("Add successfully");
        }else{
            System.out.println("Add failed");
        }
    }
    
    public void deleteTask(){
        System.out.println("------ Delete Task ------");
        if(taskManager.deleteTask(TaskView.inputID())){
            System.out.println("Delete successfully");
        }else{
            System.out.println("Delete failed");
        }
    }
    
    public void displayTask(){
        System.out.println("------ Task ------");
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task objTask : taskManager.getListTask()) {
            System.out.println(objTask);
        }
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        while (true) {    
            displayMenu();
            int iChoice = DataInput.inputIntNumber("Enter your choice", 1, 4);
            switch(iChoice){
                case 1:
                    m.addTask();
                    break;
                case 2:
                    m.deleteTask();
                    break;
                case 3:
                    m.displayTask();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
    
}
