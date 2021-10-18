/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0071;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class TaskHandler {
    private ArrayList<Task> listTask = new ArrayList<>();
    
    public ArrayList<Task> getListTask(){
        return listTask;
    }
    
    public void addTask(Task newTask){
        listTask.add(newTask);
    }
    
    public int getIndex(int id) {
        for (int i = 0; i < listTask.size(); i++) {
            if (i == id - 1) {
                return i;
            }
        }
        return -1;
    }
    
    public int deleteTask(int index) {
        DataInput dataInputer = new DataInput();
        if (listTask.isEmpty()) {
            return 0;
        }
        if (index != -1) {
            listTask.remove(index);
            return 1;
        } else {
            return -1;
        }
    }
}
