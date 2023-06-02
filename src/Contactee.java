
import java.util.ArrayList;
import java.util.List;

public class Contactee {
    protected static String name;
    protected static String phoneNum;

    protected ArrayList<Contactee> contactList = new ArrayList<>();



    Contactee luis = new Contactee("luis", "1456785246");
    Contactee tyresz = new Contactee("tyresz", "12345678996");
    Contactee rob = new Contactee("rob", "49245846544");


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-15s |", name, phoneNum);
    }


    public Contactee(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }
}
