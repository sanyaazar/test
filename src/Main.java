import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    completeTask();
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nМеню: ");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Отметить задачу как выполненную");
        System.out.println("3. Отобразить список задач");
        System.out.println("4. Завершить программу");
        System.out.println("Выберите действие: ");
    }
    private static void addTask() {
        System.out.println("Введите задачу: ");
        String taskDescription = scanner.nextLine();
        Task task = new Task(taskDescription);
        tasks.add(task);
        System.out.println("Задача добавлена: " + taskDescription);
    }
    private static void completeTask() {
        System.out.println("Введите номер задачи для отметки выполненной: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 1 && index <= tasks.size()) {
            Task task = tasks.get(index - 1);
            task.setCompleted(true);
            System.out.println("Задача выполнена: " + task.getDescription());
        } else {
            System.out.println("Некорректный номер задачи.");
        }
    }
    private static void displayTasks() {
        System.out.println("\nСписок задач:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isCompleted() ? "Готово" : "В процессе";
            System.out.println((i + 1) + ". " + task.getDescription() + " - " + status);
        }
    }

}