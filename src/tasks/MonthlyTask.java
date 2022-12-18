package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{

    public MonthlyTask(int id, String title, String description, LocalDateTime taskDataTime, TaskType taskType) {
        super(title, description, taskDataTime, taskType);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getTaskDataTime().toLocalDate();
        return taskDate.equals(localDate) || (taskDate.isBefore(localDate) && taskDate.getDayOfMonth() == localDate.getDayOfMonth());
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.MONTHLY;
    }
}
