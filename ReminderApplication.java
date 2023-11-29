import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reminder {
    private String reminderText;
    private boolean isEnabled;

    public Reminder(String reminderText) {
        this.reminderText = reminderText;
        this.isEnabled = true;
    }

    public String getReminderText() {
        return reminderText;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void disable() {
        this.isEnabled = false;
    }

    public void enable() {
        this.isEnabled = true;
    }
}

public class ReminderApplication {
    private List<Reminder> reminders;
    private Scanner scanner;

    public ReminderApplication() {
        reminders = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addReminder();
                    break;
                case 2:
                    modifyReminder();
                    break;
                case 3:
                    deleteReminder();
                    break;
                case 4:
                    enableReminder();
                    break;
                case 5:
                    viewReminders();
                    break;
                case 6:
                    System.out.println("Logging out. Bye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nReminder Application Menu:");
        System.out.println("1. Add Reminder");
        System.out.println("2. Modify Reminder");
        System.out.println("3. Delete Reminder");
        System.out.println("4. Enable Reminder");
        System.out.println("5. View Reminders");
        System.out.println("6. Logout");
        System.out.print("Enter your choice: ");
    }

    private void addReminder() {
        System.out.print("Enter the reminder text: ");
        String text = scanner.nextLine();
        reminders.add(new Reminder(text));
        System.out.println("Reminder added successfully!");
    }

    private void modifyReminder() {
        System.out.print("Enter the index of the reminder to modify: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < reminders.size()) {
            System.out.print("Enter the new reminder text: ");
            String newText = scanner.nextLine();
            reminders.get(index).disable(); // Disable the old reminder
            reminders.add(index, new Reminder(newText));
            System.out.println("Reminder modified successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    private void deleteReminder() {
        System.out.print("Enter the index of the reminder to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < reminders.size()) {
            reminders.remove(index);
            System.out.println("Reminder deleted successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    private void enableReminder() {
        System.out.print("Enter the index of the reminder to enable: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < reminders.size()) {
            reminders.get(index).enable();
            System.out.println("Reminder enabled successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    private void viewReminders() {
        if (reminders.isEmpty()) {
            System.out.println("No reminders available!");
        } else {
            System.out.println("List of Reminders:");
            for (int i = 0; i < reminders.size(); i++) {
                Reminder reminder = reminders.get(i);
                System.out.println(i + ". " + reminder.getReminderText() +
                        " - " + (reminder.isEnabled() ? "Enabled" : "Disabled"));
            }
        }
    }

    public static void main(String[] args) {
        ReminderApplication reminderApp = new ReminderApplication();
        reminderApp.start();
    }
}
