/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MacBook
 */
public class TaskView {
    
    public static Task inputTask(){
        
        Task objTask = new Task();
        
        objTask.setName(DataInput.inputString("Enter Content: "));
        
        objTask.setTypeID(DataInput.inputTaskType("Enter Task Type: ", 1, 4));
        
        objTask.setDate(DataInput.inputDate());
        
        objTask.setTimeFrom(DataInput.inputTimeFrom("Enter Time From: ", 8, 17.5));
        
        objTask.setTimeTo(DataInput.inputTimeTo("Enter Time To: ", objTask.getTimeFrom(), 17.5));
        
        objTask.setAssignee(DataInput.inputString("Enter Assignee: "));
        
        objTask.setReviewer(DataInput.inputString("Enter Reviewer: "));
        
        return objTask;
    }
    
    public static int inputID(){
        int id = DataInput.inputIntNumber("Enter ID: ", 1, Integer.MAX_VALUE);
        return id;
    }
}
