import java.time.LocalDate;
import java.util.Scanner;

public class SmartTaskSchedulerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n--- Smart Task Scheduler ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Task Name: ");
                    String name = sc.nextLine();

                    System.out.print("Priority (1=HIGH,2=MEDIUM,3=LOW): ");
                    int priority = sc.nextInt();

                    System.out.print("Due Date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(sc.next());

                    manager.addTask(id, name, priority, date);
                }
                case 2 -> manager.viewTasks();
                case 3 -> {
                    manager.saveTasks();
                    System.out.println("Tasks saved. Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}