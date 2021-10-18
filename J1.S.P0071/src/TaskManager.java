
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MacBook
 */
public class TaskManager {
    
    ArrayList<Task> listTask = new ArrayList<>();
    int autoID = 0;

    public ArrayList<Task> getListTask() {
        return listTask;
    }
    
    //add task
    public boolean addTask(Task objTask){
        if(objTask == null){
            return false;
        }else{
            autoID++;
            objTask.setId(autoID);
            listTask.add(objTask);
            return true;
        }
    }
    
    //Delete task
    public boolean deleteTask(int taskID){
        for (int i = 0; i < listTask.size(); i++) {
            if(listTask.get(i).getId() == taskID){
                listTask.remove(i);
                return true;
            }
        }
        return false;
    }
}
