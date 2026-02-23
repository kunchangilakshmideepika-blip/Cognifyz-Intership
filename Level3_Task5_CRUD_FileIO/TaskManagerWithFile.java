package Level3_Task5_CRUD_FileIO;

import java.io.*;
import java.util.*;

public class TaskManagerWithFile {

    static final String FILE_NAME = "tasks.txt";
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
        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);

            System.out.print("Enter Task ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Task Title: ");
            String title = sc.nextLine();

            fw.write(id + "," + title + "\n");
            fw.close();

            System.out.println("Task saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving task.");
        }
    }

    static void viewTasks() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            System.out.println("Saved Tasks:");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("ID: " + parts[0] + " | Title: " + parts[1]);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("No tasks found.");
        }
    }

    static void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        int idToDelete = sc.nextInt();

        try {
            File inputFile = new File(FILE_NAME);
            File tempFile = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter fw = new FileWriter(tempFile);

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);

                if (id != idToDelete) {
                    fw.write(line + "\n");
                }
            }

            br.close();
            fw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            System.out.println("Task deleted successfully!");

        } catch (IOException e) {
            System.out.println("Error deleting task.");
        }
    }
}