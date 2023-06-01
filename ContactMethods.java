import java.util.ArrayList;

abstract class ContactMethods {

    protected ArrayList<Contactee> contactList = new ArrayList<>();




    public static void main(String[] args) {
        ArrayList<Contactee> contactlist = new ArrayList<>();
        Contactee tyresz = new Contactee("tyresz","01000101001");
        contactlist.add(tyresz);
        contactlist.add(tyresz);
        contactlist.add(tyresz);
        contactlist.add(tyresz);
        System.out.println(contactlist.size());

    }

    public void printContacts() {
        String s = "";
        for (Contactee contactee : contactList) {
            s = contactList + contactee.name;
        }
        System.out.println(s);
    }
}
