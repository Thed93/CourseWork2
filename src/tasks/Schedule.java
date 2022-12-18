package tasks;

import java.util.*;
import java.time.LocalDate;

public class Schedule {

    private final Map<Integer, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        this.tasks.put(task.getId(), task);
    }

    public Collection<Task> getTaskForDate (LocalDate data) {
        List<Task> taskForDate = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.appearsIn(data)) {
                taskForDate.add(task);
            }
        }
        return taskForDate;
    }

    public void removeTask(int id) {
        this.tasks.remove(id);
    }
}
