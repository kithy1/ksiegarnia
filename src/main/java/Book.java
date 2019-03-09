import java.util.List;

public class Book {
    private int id;
    private String title;
    private String isbd;
    private int year;
    private char cover;
    private List<Author> author;
    private Category category;

    public Book() {
    }

    public Book(int id, String title, String isbd, int year, char cover, List<Author> author, Category category)  {
        this.id = id;
        this.title = title;
        this.isbd = isbd;
        this.year = year;
        this.cover = cover;
        this.author = author;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbd() {
        return isbd;
    }

    public void setIsbd(String isbd) {
        this.isbd = isbd;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbd='" + isbd + '\'' +
                ", year=" + year +
                ", cover=" + cover +"\n"+
                "author=" + author +"\n"+
                "category=" + category +
                "\n";
    }
}
