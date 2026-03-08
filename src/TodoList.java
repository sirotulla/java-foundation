import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    //Problem Statement
    //Create a simple To-Do list application that allows the user to:

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    updateStatus(scanner);
                    break;

                case 4:
                    removeTask(scanner);
                    break;

                case 5:
                    System.out.println("Exiting the program...\nGood Bye");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        scanner.close();

    }

    private static final ArrayList<String> todoList = new ArrayList<>();
    private static final ArrayList<Boolean> isCompleted = new ArrayList<>();

    //Display menu
    private static void printMenu(){
        System.out.println("-----------------------------------------");
        System.out.println("To-Do List Application");
        System.out.println("1. Add task: ");
        System.out.println("2. View all tasks: ");
        System.out.println("3. Mark a task as completed: ");
        System.out.println("4. Remove a task: ");
        System.out.println("5. Exit the application: ");
        System.out.println("-----------------------------------------");
    }

    //Add a task
    private static void addTask(Scanner scanner){
        System.out.print("Enter the task name: ");
        String task = scanner.nextLine().trim();
        if (task.isEmpty()) {
            System.out.println("You cannot add an empty task. ");
            return;
        }
        todoList.add(task);
        isCompleted.add(false);
        System.out.println("Task added successfully!");
        System.out.println(task + " -- pending");

    }

    //View all tasks
    private static void viewTasks(){
        if (todoList.isEmpty()){
            System.out.println("No tasks available");
            return;
        }
        System.out.println("-----------------------------------------");
        System.out.println("Task list \n#. Name  --  Status ");
        for (int i = 0; i < todoList.size(); i++) {
            String task = todoList.get(i);
            String status = isCompleted.get(i) ? "completed" : "pending";
            System.out.println((i + 1) + ". " + task  + " -- " + status);
        }
    }


    //Mark a task as completed
    private static void updateStatus(Scanner scanner) {
        viewTasks();
        if (todoList.isEmpty()) return;

        System.out.print("Enter the task number to mark as completed: ");
        int taskNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (taskNum > 0 && taskNum <= todoList.size()) {
            isCompleted.set(taskNum-1, true);
            System.out.println(todoList.get(taskNum-1) + " marked as completed");
        } else {
            System.out.println("Invalid task number");
        }

    }


    //Remove a task
    private static void removeTask(Scanner scanner){
        viewTasks();
        if (todoList.isEmpty()) return;

        System.out.print("Enter the task number to remove: ");
        int taskNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (taskNum > 0 && taskNum <= todoList.size()) {
            String removedTask = todoList.remove(taskNum-1);
            isCompleted.remove(taskNum-1);
            System.out.println(removedTask + " removed successfully");
        } else {
            System.out.println("Invalid task number");
        }

    }

}
