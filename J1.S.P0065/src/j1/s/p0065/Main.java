package j1.s.p0065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Quang - HE140675
 */
public class Main {
    public static final List<Student> listStudent = new ArrayList<>();
    public static void main(String[] args) {
        // TODO code application logic here
        display();
    }
    
    // Add new students
    static void createStudent(List<Student> ls){
        Validation validatior = new Validation();
        boolean check = true;
        while (check) {
            System.out.print("Name: ");
            String name = validatior.getStringInput();
            System.out.print("Classes: ");
            String className = validatior.getStringInput();
            double math = validatior.getDoubleInput("Maths: ");
            double chemistry = validatior.getDoubleInput("Chemistry: ");
            double physics = validatior.getDoubleInput("Physics: ");
            double average = 0;
            char type = 'A';
            ls.add(new Student(name, className, math, physics, chemistry, average, type));
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (!validatior.checkYesNo()) {
                return;
            }
        }
    }
 
    // Show infomation of all student and percent type student of class
    public static void display() {
        ManageStudent processing = new ManageStudent();
        createStudent(listStudent);
        int i = 0;
        for (Student mem : listStudent) {
            System.out.println("Student " + (++i) + " info");
            System.out.println("Name: " + mem.getStudentName());
            System.out.println("Classes: " + mem.getClassName());
            System.out.println("AVG: " + mem.getAverage());
            System.out.println("Type: " + mem.getType());
        }
        HashMap<String, Double> getPercentTypeStudent = processing.getPercentTypeStudent(listStudent);
        for (Map.Entry student : getPercentTypeStudent.entrySet()) {
            System.out.println(student.getKey() + " :" + student.getValue() + "%");
        }
    }
}
