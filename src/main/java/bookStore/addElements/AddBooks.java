package bookStore.addElements;

import bookStore.elements.Author;
import bookStore.elements.Book;
import bookStore.elements.Category;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AddBooks {

    public List<Book> getNewListOfBooks() throws IOException {
        List<Book> bookList = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        try {


            Stream<String> lines = Files.lines(Paths.get("books.csv"));
            List<String> dataList = new ArrayList<>();
            lines.forEach(x -> dataList.add(x));

            for (String s : dataList) {
                String[] split = s.split(";");

                System.out.println();
                int id = Integer.valueOf(split[0]);
                String title = split[1];
                String isbd = split[2];
                int year = Integer.valueOf(split[3]);
                char cover = split[4].charAt(0);
                String[] authorsId = split[5].split(",");


                for (int i = 0; i < authorsId.length; i++) {
                    int finalI = i;
                    authors.add(new AddAuthors().getNewListOfAutors("authors.csv").stream()
                            .filter(author -> author.getId() == Integer.valueOf(authorsId[finalI]))
                            .findFirst().get());

                }
                Category category;
                int categoryId = Integer.valueOf(split[6]);
                category = (new AddCategories().getNewListOfCategories().stream()
                        .filter(c -> c.getId() == categoryId)
                        .findFirst().get());

                bookList.add(new Book(id, title, isbd, year, cover, authors, category));


            }
        }catch (FileNotFoundException e){
            System.out.println("W podanej lokalizacji nie znaleziono pliku");
        }

        return bookList;
    }




}
