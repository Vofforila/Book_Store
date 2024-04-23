package Objects;

import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private String name;
    private List<Book> borrowedBooks;
    private List<LibraryItem> borrowedItems;

    private List<Borrower> borrowers = new ArrayList<>();


    public String getName() {
        return name;
    }

    public Borrower(String name) {
        this.name = name;
        borrowedBooks = new ArrayList<>();
        borrowedItems = new ArrayList<>();
        borrowers.add(this);
    }
    public Borrower findBorrower(String title) {
        for (Borrower borrower : borrowers) {
            if (borrower.getName().equalsIgnoreCase(title)) {
                return borrower;
            }
        }
        return null;
    }

    public void borrowBook(Book book) {
        if (book.getNumCopies() > 0) {
            borrowedBooks.add(book);
            book.decreaseNumCopies(1);
            System.out.println(name + " has borrowed " + book.getTitle());
        } else {
            System.out.println("Sorry, " + book.getTitle() + " is not available for borrowing.");
        }
    }

    public void borrowItem(Non_Book non_book) {
        if (non_book.getNumCopies() > 0) {
            borrowedItems.add(non_book);
            non_book.decreaseNumCopies(1);
            System.out.println(name + " has borrowed " + non_book.getTitle());
        } else {
            System.out.println("Sorry, " + non_book.getTitle() + " is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        System.out.println(borrowedBooks);
        System.out.println(book);
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.increaseNumCopies(1);
            System.out.println(name + " has returned " + book.getTitle());
        } else {
            System.out.println(name + " did not borrow " + book.getTitle());
        }
    }

    public void returnItem(LibraryItem non_book) {
        if (borrowedItems.contains(non_book)) {
            borrowedItems.remove(non_book);
            non_book.increaseNumCopies(1);
            System.out.println(name + " has returned " + non_book.getTitle());
        } else {
            System.out.println(name + " did not borrow " + non_book.getTitle());
        }
    }
}
