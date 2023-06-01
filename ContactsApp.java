import java.util.ArrayList;

public class ContactsApp extends ContactMethods{

    public static void main(String[] args) {
        ContactMethods contactMethods = new ContactMethods();

        ArrayList<Contactee> contactlist = new ArrayList<>();
        Contactee tyresz = new Contactee("tyresz","01000101001");
        contactlist.add(tyresz);
        Contactee luiz = new Contactee("Luiz", "010001010111");
        contactlist.add(luiz);


        for (Contactee contactee : contactlist) {
            printContacts(contactee);
        }



    }
}
