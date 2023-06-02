import java.util.Scanner;

public class ContactsApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice;

        ContactMethods contactMethods = new ContactMethods();

        contactMethods.loadContactsFromFile();

        do {
            System.out.println("1. View Contacts");
            System.out.println("2. Add new contact");
            System.out.println("3. Search a contact by name");
            System.out.println("4. Delete an existing contact");
            System.out.println("5. Exit");
            System.out.println("Enter an option (1, 2, 3, 4, or 5): ");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    contactMethods.printStringsToConsole();
                    break;
                case "2":
                    contactMethods.addContacts();
                    break;
                case "3":
                    contactMethods.searchContact();
                    break;
                case "4":
                    contactMethods.deleteContact();
                    break;
                case "5":
                    break; // Exit
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (!choice.equals("5"));
        System.out.println();
    }
}