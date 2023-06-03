import java.util.Scanner;

public class ContactsApp {

    public static void main(String[] args) {
        ContactManager manager = new ContactManager("contacts.txt");
        while (true) {
            manager.showMainMenu();
            int choice = manager.getUserChoice();
            switch (choice) {
                case 1:
                    manager.viewContacts();
                    break;
                case 2:
                    manager.addContact();
                    break;
                case 3:
                    manager.searchContacts();
                    break;
                case 4:
                    manager.deleteContact();
                    break;
                case 5:
                    manager.writeContactsToFile();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}