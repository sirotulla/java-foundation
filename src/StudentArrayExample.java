import java.util.Scanner;

public class StudentArrayExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many students you want to enter:? ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();  // consume newline

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student" + (i + 1) + ": ");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Roll Number: ");
            int rollNum = scanner.nextInt();

            System.out.print("Age: ");
            int age = scanner.nextInt();

            System.out.print("Height (in cm): ");
            int height = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.println("----------------------------------------------");
            students[i] = new Student(name, rollNum, age, height);
            students[i].displayStudent();
            System.out.println("----------------------------------------------");

        }

        calculateAndDisplayStatistics(students);
        scanner.close();
    }

    public static void calculateAndDisplayStatistics(Student[] students) {
        int totalAge = 0;
        double totalHeight = 0.0;
        int oldestAge = students[0].age;
        double tallestHeight = students[0].height;
        String oldestStudent = students[0].name;
        String tallestStudent = students[0].name;

        for (Student student : students) {

            totalAge += student.age;
            totalHeight += student.height;

            if (oldestAge < student.age) {
                oldestAge = student.age;
                oldestStudent = student.name;
            }

            if (tallestHeight < student.height) {
                tallestHeight = student.height;
                tallestStudent = student.name;
            }
        }

        double averageAge = (double) totalAge/students.length;
        double averageHeight = totalHeight/students.length;

        System.out.println("--- Statistics ---");
        System.out.printf("Average Age: %.2f years\n", averageAge);
        System.out.printf("Average Height: %.2f cm\n", averageHeight);
        System.out.println("Oldest Student: " + oldestStudent + " (Age: " + oldestAge + " years)");
        System.out.println("Tallest Student: " + tallestStudent + " (Height: " + tallestHeight + " cm)");

    }

}
