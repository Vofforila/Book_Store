package Objects;

public abstract class LibraryItem {

    public enum ItemType {
        DVD,
        MAGAZINE,
        MANGA,
        DEFAULT
    }

    private String id;
    private ItemType itemType;

    public ItemType getItemType() {
        return itemType;
    }

    public LibraryItem(String id, ItemType itemType) {
        this.id = id;
        this.itemType = itemType;
    }

    public  abstract  void increaseNumCopies(int num);
    public  abstract  void decreaseNumCopies(int num);

    public abstract String getTitle();
    public abstract int getNumCopies();

}
