
import java.util.ArrayList;
import java.util.Scanner;


class ContactMethods {

    ArrayList<Contactee> contactList = new ArrayList<>();


    private final Scanner sc = new Scanner(System.in);

    public void addContacts() {
        System.out.println("Name of contact: ");
        String newName = sc.nextLine();
        System.out.println("Phone Number: ");
        String newNum = sc.nextLine();
        Contactee newPerson = new Contactee(newName, newNum);
        for (Contactee contactee : contactList) {
            if (contactee.getName().equalsIgnoreCase(newPerson.getName())) {
                System.out.println("Person already exists. Do you want to add anyway? (y/n)");
                String response = sc.nextLine();
                if (response.equalsIgnoreCase("y")) {
                    contactList.add(newPerson);
                    System.out.printf("%s has been added to the contacts.%n", newName);
                } else {
                    System.out.println("Contact not added.");
                }
            }
            return;
        }
        contactList.add(newPerson);
        System.out.printf("%s has been added to the contacts.%n", newName);
        System.out.println("------------------------");
    }

    public void deleteContact(){
        System.out.println("Name of contact to delete: ");
        String nameToDelete = sc.nextLine();
        for (Contactee contactee : contactList) {
            if(contactee.getName().equalsIgnoreCase(nameToDelete)){
                System.out.printf("%s has been deleted from the contacts.%n", nameToDelete);
                contactList.remove(contactee);
            }else{
                System.out.printf("%s was not found in the contacts.%n", nameToDelete);
            }
        }
        System.out.println("------------------------");
    }

    public void printStringsToConsole(){
        System.out.println("Name       | Phone Number    |");
        System.out.println("------------------------------");
        for (Contactee contactee : contactList) {
            System.out.println(contactee.toString());
        }
        System.out.println("------------------------");
    }




    public void searchContact() {
        System.out.println("\nEnter a Contact name to see more about them: ");

        String chosenContact = sc.nextLine();

        //retrieve the student from the map
        for (Contactee contactee : contactList) {
            if (contactee.getName().equalsIgnoreCase(chosenContact)) {
                System.out.println("Name: " + contactee.getName());
                System.out.println("Phone #: " + contactee.getPhoneNum());
            }

        }
    }



}

