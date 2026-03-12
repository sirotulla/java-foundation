import javax.swing.*;

public class Student {
    String name;
    int rollNum;
    int age;
    double height;

    public Student(String name, int rollNum, int age, double height) {
        this.name = name;
        this.rollNum = rollNum;
        this.age = age;
        this.height = height;
    }

    public void displayStudent() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNum);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
    }

}
