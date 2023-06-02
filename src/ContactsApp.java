import java.util.ArrayList;
import java.util.Scanner;

public class ContactsApp extends ContactMethods{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice;

        ContactMethods contactMethods = new ContactMethods();

        ArrayList<Contactee> contactlist = new ArrayList<>();

        Contactee tyresz = new Contactee("tyresz","01000101001");
        contactlist.add(tyresz);

        Contactee luis = new Contactee("Luis", "010001010111");
        contactlist.add(luis);







        do {
            System.out.println("1. View Contacts");
//            System.out.println("2. Add new contact");
//            System.out.println("3. Search a contact by name");
//            System.out.println("4. Delete an existing contact");
            System.out.println("5. Exit");
            System.out.println(" Enter an option (1, 2, 3, 4, or 5): ");
            choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.println("Name       | Phone Number    |");
                    System.out.println("------------------------------");
                    for (Contactee contactee : contactlist) {
                        System.out.println(contactee.toString());
                    }
//                case "2" -> {}//ADD NEW CONTACT
//                case "3" -> System.out.println("Exiting the application. Have a good day....I SAID GOOD DAY!");
//                case "4" -> {}//Delete an existing contact
                }
                case "5"->{} //Exit

            }
            System.out.println();

        } while (!choice.equals("5"));
    }

    }

