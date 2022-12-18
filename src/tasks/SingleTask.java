package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static tasks.Repeatability.SINGLE;

public class SingleTask extends Task {

    public SingleTask(String title, String description, LocalDateTime taskDataTime, TaskType taskType) {
        super(title, description, taskDataTime, taskType);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(this.getTaskDataTime().toLocalDate());
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.SINGLE;
    }
}
