import java.io.*;
import java.time.LocalDate;
import java.util.PriorityQueue;

public class TaskManager {

    private PriorityQueue<Task> queue = new PriorityQueue<>();
    private static final String FILE_NAME = "tasks.dat";

    public TaskManager() {
        loadTasks();
    }

    public void addTask(int id, String name, int priority, LocalDate date) {
        queue.add(new Task(id, name, priority, date));
        System.out.println("Task added successfully.");
    }

    public void viewTasks() {
        if (queue.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n--- Scheduled Tasks ---");
        for (Task t : queue) {
            System.out.println(t);
        }
    }

    public void saveTasks() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(queue);
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    @SuppressWarnings("unchecked")
    private void loadTasks() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            queue = (PriorityQueue<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading tasks.");
        }
    }
}