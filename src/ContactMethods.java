import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

public class ContactMethods {

    ArrayList<Contactee> contactList = Contactee.contactList;
    private final Scanner sc = new Scanner(System.in);
    private final String relativePath = "contacts.txt";

    public void addContacts() {
        System.out.println("Name of contact: ");
        String newName = sc.nextLine();
        System.out.println("Phone Number: ");
        String newNum = sc.nextLine();
        Contactee newPerson = new Contactee(newName, newNum);

        if (contactList.contains(newPerson)) {
            System.out.println("Person already exists. Do you want to add anyway? (y/n)");
            String response = sc.nextLine();
            if (response.equalsIgnoreCase("y")) {
                contactList.add(newPerson);
                System.out.printf("%s has been added to the contacts.%n", newName);
                printContactToFile();
            } else {
                System.out.println("Contact not added.");
            }
            return;
        }

        contactList.add(newPerson);
        System.out.printf("%s has been added to the contacts.%n", newName);
        System.out.println("------------------------------");
        printContactToFile();
    }

    public void deleteContact() {
        System.out.println("Name of contact to delete: ");
        String nameToDelete = sc.nextLine();
        try {
            for (Contactee contactee : contactList) {
                if (contactee.getName().equalsIgnoreCase(nameToDelete)) {
                    contactList.remove(contactee);
                    System.out.printf("%s has been deleted from the contacts.%n", nameToDelete);
                    return;
                }
            }
            System.out.printf("%s was not found in the contacts.%n", nameToDelete);
        } catch (ConcurrentModificationException e) {
            System.out.println("An error occurred while deleting the contact.");
        }
        System.out.println("------------------------------");
    }

    public void printStringsToConsole() {
        String relativePath = "contacts.txt";
        Path inputPath = Paths.get(relativePath);
        try {
            List<String> lines = Files.readAllLines(inputPath);
            System.out.println("Name       | Phone Number    |");
            System.out.println("------------------------------");
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String phoneNum = parts[1].trim();
                    System.out.printf("%-10s | %-15s |%n", name, phoneNum);
                }
            }
            System.out.println("------------------------------");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void searchContact() {
        System.out.println("\nEnter a Contact name to see more about them: ");
        String chosenContact = sc.nextLine();
        for (Contactee contactee : contactList) {
            if (contactee.getName().equalsIgnoreCase(chosenContact)) {
                System.out.println("Name: " + contactee.getName());
                System.out.println("Phone #: " + contactee.getPhoneNum());
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void printContactToFile() {
        Path outputPath = Paths.get(relativePath);
        try {
            List<String> formattedContacts = new ArrayList<>();
            for (Contactee contactee : contactList) {
                formattedContacts.add(contactee.getName() + "," + contactee.getPhoneNum());
            }
            Files.write(outputPath, formattedContacts, Charset.defaultCharset());
        } catch (IOException exception) {
            System.out.println("An error occurred while writing to the file.");
            exception.printStackTrace();
        }
    }


    public void loadContactsFromFile() {
        Path inputPath = Paths.get(relativePath);
        try {
            List<String> lines = Files.readAllLines(inputPath);
            for (String line : lines) {
                String[] contactData = line.split(",");
                if (contactData.length == 2) {
                    String name = contactData[0].trim();
                    String phoneNum = contactData[1].trim();
                    Contactee contactee = new Contactee(name, phoneNum);
                    contactList.add(contactee);
                }
            }
        } catch (IOException exception) {
            System.out.println("An error occurred while reading the file.");
            exception.printStackTrace();
        }
    }
}