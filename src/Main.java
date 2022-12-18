import tasks.Schedule;
import tasks.SingleTask;
import tasks.Task;
import tasks.TaskType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    private static final Schedule SCHEDULE = new Schedule();

    private static final DateTimeFormatter DATA_TIME = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SCHEDULE.addTask(new SingleTask("Single", "test", LocalDateTime.now(), TaskType.PERSONAL));
        SCHEDULE.addTask(new SingleTask("Daily", "test", LocalDateTime.now(), TaskType.PERSONAL));
        printTaskForDate(scanner);
    }

    private static void printTaskForDate(Scanner scanner) {
        LocalDate localDate = readDate(scanner);
        Collection<Task> taskForDate = SCHEDULE.getTaskForDate(localDate);
        System.out.println("Задача на " + localDate.format(DATA_TIME));
        for (Task task : taskForDate) {
            System.out.printf("[%s]%s: %s (%s)%n",
                    localizeType(task.getTaskType()),
                    task.getTitle(),
                    task.getTaskDataTime().format(DATA_TIME),
                    task.getDescription());
        }
    }

    private static LocalDate readDate(Scanner scanner) {
        while (true) {
            try {

                System.out.print("Введите дату задачи в формате dd.MM.yyyy");
                String dateLine = scanner.nextLine();
                return LocalDate.parse(dateLine, DATA_TIME);
            } catch (DateTimeParseException e) {
                System.out.println("Введена дата в неверном формате");
            }
        }
    }
    private static String localizeType(TaskType taskType) {
        return switch (taskType) {
            case WORKING -> "Рабочая задача";
            case PERSONAL -> "Персональная задача";
        };
    }
}