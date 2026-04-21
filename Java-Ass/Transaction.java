import java.time.LocalDate;

public class Transaction {
    int bookId;
    LocalDate issueDate;
    LocalDate returnDate;
    boolean returned;

    public Transaction(int bookId) {
        this.bookId = bookId;
        this.issueDate = LocalDate.now();
        this.returned = false;
    }

    public void returnBook() {
        this.returnDate = LocalDate.now();
        this.returned = true;
    }
}