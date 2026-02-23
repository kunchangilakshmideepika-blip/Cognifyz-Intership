package Level2_Task3_CRUD_ConsoleApp;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    static ArrayList<Task> taskList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    static void addTask() {
        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Task Title: ");
        String title = sc.nextLine();

        taskList.add(new Task(id, title));
        System.out.println("Task Added Successfully!");
    }

    static void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task t : taskList) {
                System.out.println(t);
            }
        }
    }

    static void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        int id = sc.nextInt();

        taskList.removeIf(t -> t.id == id);
        System.out.println("Task deleted (if ID existed).");
    }
}