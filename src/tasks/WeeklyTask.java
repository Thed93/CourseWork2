package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task{

    public WeeklyTask(int id, String title, String description, LocalDateTime taskDataTime, TaskType taskType) {
        super(title, description, taskDataTime, taskType);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskData = this.getTaskDataTime().toLocalDate();
        return localDate.equals(taskData) || (localDate.isAfter(taskData) && localDate.getDayOfWeek().equals(taskData.getDayOfWeek()));
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.WEAKLY;
    }
}
