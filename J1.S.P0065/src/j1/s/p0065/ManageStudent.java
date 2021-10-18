/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0065;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author dell
 */
public class ManageStudent {
    HashMap<String, Double> getPercentTypeStudent(List<Student> ls) {
        HashMap<String, Double> calPercentTypeStudent = new HashMap<>();
        int totalStudent = ls.size();
        double typeA = 0;
        double typeB = 0;
        double typeC = 0;
        double typeD = 0;
        for (int i = 0; i < totalStudent; i++) {
            if (ls.get(i).getType() == 'A') {
                typeA++;
            }
            if (ls.get(i).getType() == 'B') {
                typeB++;
            }
            if (ls.get(i).getType() == 'C') {
                typeC++;
            }
            if (ls.get(i).getType() == 'D') {
                typeD++;
            }
        }
        calPercentTypeStudent.put("A", typeA / totalStudent * 100);
        calPercentTypeStudent.put("B", typeB / totalStudent * 100);
        calPercentTypeStudent.put("C", typeC / totalStudent * 100);
        calPercentTypeStudent.put("D", typeD / totalStudent * 100);
        return calPercentTypeStudent;
    }
}
