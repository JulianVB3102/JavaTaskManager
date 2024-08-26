import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description, LocalDate dueDate, int priority) {
        tasks.add(new Task(description, dueDate, priority));
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).complete();
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ": " + tasks.get(i));
            }
        }
    }

    public void saveTasksToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(tasks);
            System.out.println("Tasks saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public void loadTasksFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            tasks = (ArrayList<Task>) ois.readObject();
            System.out.println("Tasks loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Manager:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Complete Task");
            System.out.println("4. List Tasks");
            System.out.println("5. Save Tasks to File");
            System.out.println("6. Load Tasks from File");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    LocalDate dueDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter priority (1 - High, 2 - Medium, 3 - Low): ");
                    int priority = scanner.nextInt();
                    manager.addTask(description, dueDate, priority);
                    break;
                case 2:
                    System.out.print("Enter task index to remove: ");
                    int removeIndex = scanner.nextInt();
                    manager.removeTask(removeIndex);
                    break;
                case 3:
                    System.out.print("Enter task index to complete: ");
                    int completeIndex = scanner.nextInt();
                    manager.completeTask(completeIndex);
                    break;
                case 4:
                    manager.listTasks();
                    break;
                case 5:
                    System.out.print("Enter filename to save tasks: ");
                    String saveFilename = scanner.next();
                    manager.saveTasksToFile(saveFilename);
                    break;
                case 6:
                    System.out.print("Enter filename to load tasks: ");
                    String loadFilename = scanner.next();
                    manager.loadTasksFromFile(loadFilename);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
