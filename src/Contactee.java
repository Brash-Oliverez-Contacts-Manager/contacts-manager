
import java.util.ArrayList;
import java.util.List;

public class Contactee {
    private String name;
    private String phoneNumber;

    public Contactee(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return String.format("%-20s | %-12s", name, formatPhoneNumber(phoneNumber));
    }

    private String formatPhoneNumber(String phoneNumber) {
        // Add dashes to phone number
        if (phoneNumber.length() == 10) {
            return String.format("%s-%s-%s", phoneNumber.substring(0, 3), phoneNumber.substring(3, 6), phoneNumber.substring(6));
        } else if (phoneNumber.length() == 7) {
            return String.format("%s-%s", phoneNumber.substring(0, 3), phoneNumber.substring(3));
        } else {
            return phoneNumber;
        }
    }
}
