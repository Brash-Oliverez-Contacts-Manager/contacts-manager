import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ContactManager{
        private final List<Contactee> contacts;
        private final File contactsFile;

        public ContactManager(String fileName) {
            super();
            contacts = new ArrayList<Contactee>();
            contactsFile = new File("src/data/" + fileName);
            readContactsFromFile();
        }


    private void readContactsFromFile() {
            try {
                Scanner scanner = new Scanner(contactsFile);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        Contactee contact = new Contactee(parts[0].trim(), parts[1].trim());
                        contacts.add(contact);
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Could not read contacts file: " + e.getMessage());
            }
        }

        void writeContactsToFile() {
            try {
                FileWriter writer = new FileWriter(contactsFile);
                for (Contactee contactee : contacts) {
                    writer.write(String.format("%s,%s\n", contactee.getName(), contactee.getPhoneNumber()));
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Could not write contacts file: " + e.getMessage());
            }
        }

        public void showMainMenu() {
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
        }

        public int getUserChoice() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an option (1, 2, 3, 4 or 5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character
            return choice;
        }

        public void viewContacts() {
            System.out.printf("%-20s | %-12s\n", "Name", "Phone number");
            System.out.println("-----------------------------------");
            for (Contactee contact : contacts) {
                System.out.println(contact);
            }
        }

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String phoneNumber;
        while (true) {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            System.out.print("Enter phone number: ");
            phoneNumber = scanner.nextLine();
            Contactee newContact = new Contactee(name, phoneNumber);
            if (!contacts.contains(newContact)) {
                break;
            }
            System.out.print("There's already a contact named " + name + ". Please enter a unique name.\n");
        }
        Contactee newContact = new Contactee(name, phoneNumber);
        contacts.add(newContact);
        System.out.println("Contact added.");
    }

    public void searchContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Contactee contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone Number: " + contact.getPhoneNumber());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contacts found with name " + name + ".");
        }
    }

    public void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        boolean removed = false;
        for (Contactee contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                System.out.println("Contact deleted.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("No contacts found with name " + name + ".");
        }
    }
}

