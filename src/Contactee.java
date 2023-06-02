
import java.util.ArrayList;

public class Contactee {
    protected String name;
    protected String phoneNum;

    protected ArrayList<Contactee> contactList = new ArrayList<>();


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
