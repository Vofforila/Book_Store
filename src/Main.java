import Objects.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static Objects.LibraryItem.ItemType.*;


 /*
    ====================================================================
     Sistemul unei librarii

     Sa va asigurati ca adaugati un borrower inainte de a realiza actiuni cu acesta


    ====================================================================
     */


public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        LibrarySystem system1 = new LibrarySystem();

        while (true) {
            system1.meniu();

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    system1.add_book(scanner);
                    break;

                case 2:
                    system1.display_books(scanner);
                    break;

                case 3:
                    system1.add_borrower(scanner);
                    break;
                case 4:
                    system1.borrow_book(scanner);
                    break;

                case 5:
                    system1.return_book(scanner);
                    break;

                case 6:
                    system1.remove_book(scanner);
                    break;

                case 7:
                    system1.add_nonbook(scanner);
                    break;

                case 8:
                    system1.display_nonbook(scanner);
                    break;

                case 9:
                    system1.borrow_nonbook(scanner);
                    break;

                case 10:
                    system1.return_nonbook(scanner);
                    break;

                case 11:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;

                case 12:
                    system1.create_random_books(scanner);
                    break;
                case 13:
                    system1.print_SCV(scanner);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}