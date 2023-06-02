
import java.util.ArrayList;
import java.util.Scanner;

public class ContactsApp extends ContactMethods {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice;

        ContactMethods contactMethods = new ContactMethods();

        ArrayList<Contactee> contactlist = new ArrayList<>();

        Contactee tyresz = new Contactee("tyresz", "01000101001");
        contactlist.add(tyresz);

        Contactee luis = new Contactee("Luis", "010001010111");
        contactlist.add(luis);


        do {
            System.out.println("1. View Contacts");
            System.out.println("2. Add new contact");
            System.out.println("3. Search a contact by name");
            System.out.println("4. Delete an existing contact");
            System.out.println("5. Exit");
            System.out.println(" Enter an option (1, 2, 3, 4, or 5): ");
            choice = sc.nextLine();

            switch (choice) {


                case "1" -> {contactMethods.printStringsToConsole();}
                case "2" -> {contactMethods.addContacts();}

                case "3" -> {
                    //prompt user for input
                    System.out.println("\nEnter a username to see more about them:");
                    String chosenContact = sc.nextLine();

                    //retrieve the student from the map
                    for (Contactee contactee : contactlist) {
                        if (contactee.getName().equalsIgnoreCase(chosenContact)) {
                            System.out.println("Name: " + contactee.getName());
                            System.out.println("Phone #: " + contactee.getPhoneNum());
                        }

                    }
                }
                case "4" -> {contactMethods.deleteContact();}
                case "5" -> {} //Exit
            }

        } while (!choice.equals("5"));
        System.out.println();

    }


}
