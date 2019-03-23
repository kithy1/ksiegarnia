package bookStore.addElements;

import java.util.Scanner;

public class SourceFileName {
    String authorSourceFileName;
    String categorySourceFileName;
    String bookSoureceFileName;

    Scanner scanner = new Scanner(System.in);

    public String getAuthorSourceFileName() {
        return authorSourceFileName;
    }

    public void setAuthorSourceFileName() {

        this.authorSourceFileName = scanner.nextLine();
    }

    public String getCategorySourceFileName() {
        return categorySourceFileName;
    }

    public void setCategorySourceFileName() {

        this.categorySourceFileName = scanner.nextLine();
    }

    public String getBookSoureceFileName() {
        return bookSoureceFileName;
    }

    public void setBookSoureceFileName() {
        this.bookSoureceFileName = scanner.nextLine();
    }
}
