/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0065;

/**
 *
 * @author dell
 */
public class Student {
    private String studentName;
    private String className;
    private double math;
    private double physic;
    private double chemistry;
    private double average;
    private char type;

    public Student() {
    }

    public Student(String studentName, String className, double math, double physic, double chemistry, double average, char type) {
        this.studentName = studentName;
        this.className = className;
        this.math = math;
        this.physic = physic;
        this.chemistry = chemistry;
        this.average = average;
        this.type = type;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysic() {
        return physic;
    }

    public void setPhysic(double physic) {
        this.physic = physic;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getAverage() {
        this.average = (this.math + this.chemistry + this.physic)/3;
        this.average = Math.round(this.average*100)/100D;
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public char getType() {
        if (this.average > 7.5) {
                this.type = 'A';
        } else if (this.average >= 6 && this.average <= 7.5) {
                this.type = 'B';
        } else if (this.average >= 4 && this.average < 6) {
                this.type = 'C';
        } else {
                this.type = 'D';
        }
        return type;
    }

    public void setType(char type) {
        this.type = type;
    } 
    
}
