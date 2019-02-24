import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddBooks {

    public List<Book> getNewListOfBooks() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("books.csv"));
        List<String> dataList = new ArrayList<>();
        lines.forEach(x -> dataList.add(x));
        List<Book> bookList = new ArrayList<>();
        for (String s : dataList) {
            String[] split = s.split(";");

            System.out.println();
            int id = Integer.valueOf(split[0]);
            String title = split[1];
            String isbd = split[2];
            int year = Integer.valueOf(split[3]);
            char cover = split[4].charAt(0);
            String[] authorsId = split[5].split(",");

            List<Author> authors = new ArrayList<>();
            for (int i = 0; i <authorsId.length ; i++) {
                int finalI = i;
                authors.add(new AddAuthors().getNewListOfAutors().stream()
                        .filter(author -> author.getId()==Integer.valueOf(authorsId[finalI]))
                        .findFirst().get());

            }
            Category category;
            int categoryId = Integer.valueOf(split[6]);
            category = (new AddCategories().getNewListOfCategories().stream()
                    .filter(c -> c.getId()==categoryId)
                    .findFirst().get());

            bookList.add(new Book(id,title,isbd,year,cover,authors,category));


        }

        return bookList;
    }

    public static void main(String[] args) throws IOException {
        AddBooks addBooks = new AddBooks();
        System.out.println(addBooks.getNewListOfBooks());
    }


}