package Objects;

public class Book  {

    // instance variables
    private String title;
    private String author;
    private String id;
    private int numCopies;

    // default constructor
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.id = "Unknown id";
        this.numCopies = 0;
    }

    // constructor
    public Book(String title, String author, String id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    // getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getid() {
        return id;
    }

    public int getNumCopies() {
        return numCopies;
    }

    // methods
    public void increaseNumCopies(int num) {
        numCopies = numCopies + num;
    }

    public void decreaseNumCopies(int num) {
        numCopies = numCopies - num;
    }
}
