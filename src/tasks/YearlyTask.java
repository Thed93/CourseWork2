package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{

    public YearlyTask(int id, String title, String description, LocalDateTime taskDataTime, TaskType taskType) {
        super(title, description, taskDataTime, taskType);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = getTaskDataTime().toLocalDate();
        return localDate.equals(taskDate) || (localDate.isAfter(taskDate) &&
                localDate.getDayOfMonth() == taskDate.getDayOfMonth() &&
                localDate.getMonth().equals(taskDate.getMonth()));
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.YEARLY;
    }
}
