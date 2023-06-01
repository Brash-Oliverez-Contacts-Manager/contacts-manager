public class Contactee extends ContactMethods {
    protected String name;
    protected String phoneNum;

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

    public Contactee(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

//    public void printContacts() {
//        for (Contactee contactee : contactList) {
//            System.out.println("hello");
//        }
//    }
}
