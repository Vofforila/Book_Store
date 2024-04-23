package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Objects.LibraryItem.ItemType.*;

public class LibrarySystem {

    public LibrarySystem()
    {}

    Library myLibrary = new Library();
    Borrower borrower;
    Book chosenBook;
    LibraryItem chosenItem;



    /*
    ====================================================================
     Sistemul unei librarii

     Sa va asigurati ca adaugati un borrower inainte de a realiza actiuni cu acesta


    ====================================================================
     */

    public void meniu()
    {
        System.out.println("===============");
        System.out.println("1. Add new book");
        System.out.println("2. Display books");
        System.out.println("3. Add a borrower account");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Remove a book from the library");
        System.out.println("7. Add a non-book item");
        System.out.println("8. Display non-book items");
        System.out.println("9. Borrow non-book items");
        System.out.println("10. Return a non-book item");;
        System.out.println("11. Exit");
        System.out.println("12. Creates some random books and items");
        System.out.println("13. Print the data to a SCV File");
        System.out.println("===============");
        System.out.print("Enter your choice: ");

    }

    public void add_book(Scanner scanner){
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Enter book author: ");
        String bookAuthor = scanner.nextLine();
        myLibrary.addBook(new Book(bookTitle,bookAuthor,bookId));
    }

    public void display_books(Scanner scanner)
    {
        myLibrary.displayBooks();
    }

    public void add_borrower(Scanner scanner)
    {
        System.out.print("Enter your name: ");
        String borrowerName = scanner.nextLine();
        borrower = new Borrower(borrowerName);
    }

    public void borrow_book(Scanner scanner)
    {
        System.out.print("Enter borrower name: ");
        String borrowerName = scanner.nextLine();
        System.out.print("Enter book name: ");
        String borrowBookName = scanner.nextLine();
        borrower = borrower.findBorrower(borrowerName);
        chosenBook = myLibrary.findBookByTitle(borrowBookName);
        borrower.borrowBook(chosenBook);
    }
    public void return_book(Scanner scanner)
    {
        System.out.print("Enter borrower name: ");
        String returnBorrowerName = scanner.nextLine();
        System.out.print("Enter book name: ");
        String returnBorrowerBookName = scanner.nextLine();
        borrower = borrower.findBorrower(returnBorrowerName);
        chosenBook = myLibrary.findBookByTitle(returnBorrowerBookName);
        borrower.returnBook(chosenBook);
    }
    public void remove_book(Scanner scanner)
    {
        System.out.println("Enter the book name: ");
        String outBook = scanner.nextLine();
        chosenBook = myLibrary.findBookByTitle(outBook);
        myLibrary.removeBook(chosenBook);
    }
    public void add_nonbook(Scanner scanner)
    {
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.println("Select one of the item types: ");
        System.out.println("1.DVD ");
        System.out.println("2.MAGAZINE ");
        System.out.println("3.MANGA");
        int itemType = scanner.nextInt();
        if(itemType == 1)
        {
            myLibrary.addNon_Book(new Non_Book(itemId,itemName,DVD));
        }
        else if(itemType == 2)
        {
            myLibrary.addNon_Book(new Non_Book(itemId,itemName,DVD));
        }
        else if (itemType == 3)
        {
            myLibrary.addNon_Book(new Non_Book(itemId,itemName,DVD));
        }
    }
    public void display_nonbook(Scanner scanner)
    {
        myLibrary.displayItems();
    }
    public void borrow_nonbook(Scanner scanner)
    {
        System.out.print("Enter borrower name: ");
        String BorrowerName = scanner.nextLine();
        System.out.println("Select a item that you want to borrow:");
        myLibrary.displayItemsBuy();
        int itemNr = scanner.nextInt();
        itemNr = itemNr - 1;
        List<Non_Book> non_books = myLibrary.getItemList();
        borrower = borrower.findBorrower(BorrowerName);
        borrower.borrowItem(non_books.get(itemNr));
    }
    public void return_nonbook(Scanner scanner)
    {
        System.out.print("Enter borrower name: ");
        String returnItemBorrowerName = scanner.nextLine();
        System.out.print("Enter item name: ");
        String returnBorrowerItemName = scanner.nextLine();
        borrower = borrower.findBorrower(returnItemBorrowerName);
        chosenItem = myLibrary.findItemByTitle(returnBorrowerItemName);
        borrower.returnItem(chosenItem);
    }
    public void create_random_books(Scanner scanner)
    {
        myLibrary.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "01"));
        myLibrary.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "02"));
        myLibrary.addBook(new Book("1985", "J.D. Salinger", "03"));
        myLibrary.addNon_Book(new Non_Book("01","Michael Jackson",DVD));
        myLibrary.addNon_Book(new Non_Book("02","How to fix a car",MAGAZINE));
        myLibrary.addNon_Book(new Non_Book("03","Vinland Saga",MANGA));
    }

    public void print_SCV(Scanner scanner) throws FileNotFoundException {
        File csvFile1 = new File("books.csv");
        File csvFile2 = new File("items.csv");

        PrintWriter out1 = new PrintWriter(csvFile1);
        PrintWriter out2 = new PrintWriter(csvFile2);


        for (Book book : myLibrary.getBooks()) {
            out1.printf("%s,%s,%s,%d\n",book.getid(),book.getTitle(),book.getAuthor(),book.getNumCopies());
        }
        for (Non_Book non_book : myLibrary.getNon_books())
        {
            out2.printf("%s,%s,%d\n",non_book.getTitle(),non_book.getItemType(),non_book.getNumCopies());
        }

        out1.close();
        out2.close();
    }

}
