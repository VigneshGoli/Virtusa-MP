import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Register User");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. View Users");
            System.out.println("7. Explore User");
            System.out.println("8. View Pending Fines");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();

                    lib.addBook(new Book(id, title, author, qty));
                    break;

                case 2:
                    lib.viewBooks();
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Roll No: ");
                    String roll = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    lib.addUser(new User(roll, name, year, dept));
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Roll No: ");
                    String r1 = sc.nextLine();

                    System.out.print("Book ID: ");
                    int b1 = sc.nextInt();

                    lib.issueBook(r1, b1);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Roll No: ");
                    String r2 = sc.nextLine();

                    System.out.print("Book ID: ");
                    int b2 = sc.nextInt();

                    lib.returnBook(r2, b2);
                    break;

                case 6:
                    lib.viewUsers();
                    break;

                case 7:
                    sc.nextLine();
                    System.out.print("Enter Roll No: ");
                    String r3 = sc.nextLine();

                    lib.exploreUser(r3);
                    break;

                case 8:
                    lib.viewPendingFines();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}