import java.util.ArrayList;

public class User {
    String rollNo;
    String name;
    int year;
    String department;

    ArrayList<Transaction> transactions = new ArrayList<>();

    public User(String rollNo, String name, int year, String department) {
        this.rollNo = rollNo;
        this.name = name;
        this.year = year;
        this.department = department;
    }

    public void displayUser() {
        System.out.println(rollNo + " | " + name + " | Year: " + year + " | Dept: " + department);
    }
}