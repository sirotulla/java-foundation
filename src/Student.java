import java.util.Scanner;

public class Student {
    Scanner scanner = new Scanner(System.in);
    // Attributes (properties) of the class
    String name;
    int rollNumber;
    int age;
    double height;

    // method (behavior) of the class

    // parametrized constructure
    public Student(String name, int rollNumber, int age, double height) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
        this.height = height;
    }

    void displayStudent() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height + " cm");
    }

}

