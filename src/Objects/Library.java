package Objects;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // instance variables
    private List<Book> books;
    private static List<Non_Book> non_books;

    public static List<Non_Book> getNon_books() {
        return non_books;
    }

    public List<Book> getBooks() {
        return books;
    }

    // constructor
    public Library() {
        books = new ArrayList<>();
        non_books = new ArrayList<>();
    }

    // methods

    public List<Non_Book> getItemList()
    {
        return non_books;
    }
    public void addBook(Book book) {
        if(book.getNumCopies() == 0) {
            books.add(book);
            book.increaseNumCopies(1);
        }
        else book.increaseNumCopies(1);
    }

    public void addNon_Book(Non_Book item) {
        if(item.getNumCopies() == 0) {
            non_books.add(item);
            item.increaseNumCopies(1);
        }
        else item.increaseNumCopies(1);
    }

    public void removeBook(Book book) {
        book.decreaseNumCopies(1);
        if(book.getNumCopies() == 0)
                books.remove(book);
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ID: " + book.getid() + ", Copies: " + book.getNumCopies());
        }
        System.out.println();
    }


    public void displayItems() {
        System.out.println("Items:");
        for (LibraryItem non_book : non_books) {
            System.out.println("Name: " + non_book.getTitle() + ", Copies: " + non_book.getNumCopies() + ", Type: " + non_book.getItemType()  );
        }
        System.out.println();
    }

    public void displayItemsBuy() {
        System.out.println("Press the number for the respective item:");
        int i = 0;
        for (LibraryItem non_book : non_books) {
            i++;
            System.out.println(i + ". " + non_book.getTitle() );
        }
        System.out.println();
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    public LibraryItem findItemByTitle(String title) {
        for (LibraryItem non_book : non_books) {
            if (non_book.getTitle().equalsIgnoreCase(title)) {
                return non_book;
            }
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }

}
