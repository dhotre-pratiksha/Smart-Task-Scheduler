import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable, Comparable<Task> {

    private int id;
    private String name;
    private int priority;
    private LocalDate dueDate;

    public Task(int id, String name, int priority, LocalDate dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        String p =
                priority == 1 ? "HIGH" :
                        priority == 2 ? "MEDIUM" : "LOW";

        return "ID : " + id +
                ", Task : " + name +
                ", Priority : " + p +
                ", Due : " + dueDate;
    }
}