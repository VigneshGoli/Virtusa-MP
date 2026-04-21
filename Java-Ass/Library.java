import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added.");
    }

    // View Books (NEW)
    public void viewBooks() {
        if (books.size() == 0) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            b.displayBook();
        }
    }

    // Add User
    public void addUser(User user) {
        users.add(user);
        System.out.println("User registered.");
    }

    // Find Book
    public Book findBook(int id) {
        for (Book b : books) {
            if (b.id == id) return b;
        }
        return null;
    }

    // Find User
    public User findUser(String rollNo) {
        for (User u : users) {
            if (u.rollNo.equals(rollNo)) return u;
        }
        return null;
    }

    // Issue Book (UPDATED with quantity)
    public void issueBook(String rollNo, int bookId) {
        User user = findUser(rollNo);
        Book book = findBook(bookId);

        if (user == null || book == null) {
            System.out.println("Invalid user or book.");
            return;
        }

        if (book.quantity <= 0) {
            System.out.println("Book not available.");
            return;
        }

        book.quantity--;

        Transaction t = new Transaction(bookId);
        user.transactions.add(t);

        System.out.println("Book issued to " + user.name);
    }

    // Return Book (UPDATED)
    public void returnBook(String rollNo, int bookId) {
        User user = findUser(rollNo);
        Book book = findBook(bookId);

        if (user == null || book == null) {
            System.out.println("Invalid user or book.");
            return;
        }

        for (Transaction t : user.transactions) {
            if (t.bookId == bookId && !t.returned) {

                t.returnBook();
                book.quantity++;

                long days = ChronoUnit.DAYS.between(t.issueDate, t.returnDate);
                long fine = (days > 15) ? (days - 15) : 0;

                System.out.println("Book returned.");
                System.out.println("Days: " + days);
                System.out.println("Fine: ₹" + fine);
                return;
            }
        }

        System.out.println("No active record found.");
    }

    // View Users
    public void viewUsers() {
        for (User u : users) {
            u.displayUser();
        }
    }

    // Explore User
    public void exploreUser(String rollNo) {
        User user = findUser(rollNo);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        user.displayUser();
        long totalFine = 0;

        for (Transaction t : user.transactions) {
            Book book = findBook(t.bookId);

            System.out.print("Book: " + book.title + " | ");

            if (t.returned) {
                long days = ChronoUnit.DAYS.between(t.issueDate, t.returnDate);
                long fine = (days > 15) ? (days - 15) : 0;

                System.out.println("Returned | Fine: ₹" + fine);
                totalFine += fine;

            } else {
                long days = ChronoUnit.DAYS.between(t.issueDate, LocalDate.now());
                long fine = (days > 15) ? (days - 15) : 0;

                System.out.println("Active | Current Fine: ₹" + fine);
                totalFine += fine;
            }
        }

        System.out.println("Total Pending Fine: ₹" + totalFine);
    }

    // Pending Fines Report (NEW)
    public void viewPendingFines() {

        boolean found = false;

        for (User u : users) {

            long totalFine = 0;

            for (Transaction t : u.transactions) {

                long days;

                if (t.returned) {
                    days = ChronoUnit.DAYS.between(t.issueDate, t.returnDate);
                } else {
                    days = ChronoUnit.DAYS.between(t.issueDate, LocalDate.now());
                }

                if (days > 15) {
                    totalFine += (days - 15);
                }
            }

            if (totalFine > 0) {
                u.displayUser();
                System.out.println("Pending Fine: ₹" + totalFine);
                System.out.println("----------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No pending fines.");
        }
    }
}