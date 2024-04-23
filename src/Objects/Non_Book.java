package Objects;

import java.util.List;

public class Non_Book extends LibraryItem {

        private String title;
        private int numCopies;

    public Non_Book() {
        super("id",ItemType.DEFAULT);
        this.title = "Unknown Title";
        this.numCopies = 0;
    }

    public Non_Book(String id, String title, ItemType itemType) {
        super(id, itemType);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public void increaseNumCopies(int num)
    {
        numCopies = numCopies + num;
    }

    public void decreaseNumCopies(int num) {
        numCopies = numCopies - num;
    }

}


