import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    private String description;
    private boolean isComplete;
    private LocalDate dueDate;
    private int priority; // 1 - High, 2 - Medium, 3 - Low

    public Task(String description, LocalDate dueDate, int priority) {
        this.description = description;
        this.isComplete = false;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void complete() {
        this.isComplete = true;
    }

    @Override
    public String toString() {
        return (isComplete ? "[X] " : "[ ] ") + description + 
               " (Due: " + dueDate + ", Priority: " + priorityToString() + ")";
    }

    private String priorityToString() {
        switch (priority) {
            case 1: return "High";
            case 2: return "Medium";
            case 3: return "Low";
            default: return "Unknown";
        }
    }
}
