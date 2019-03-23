package bookStore.addElements;

import bookStore.elements.Author;
import bookStore.elements.Book;
import bookStore.elements.Category;
import bookStore.lists.Lists;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class AddBooks {

    public List<Book> getNewListOfBooks(String fileName) throws IOException {
        List<Book> bookList = new ArrayList<>();

        try(Stream<String> lines = Files.lines(Paths.get(fileName))) {
            List<String> dataList = new ArrayList<>();
            lines.forEach(x -> dataList.add(x));

            for (String s : dataList) {
                List<Author> authors = new ArrayList<>();
                String[] tablicaWartosci = s.split(";");
                int id = Integer.valueOf(tablicaWartosci[0]);
                String title = tablicaWartosci[1];
                String isbd = tablicaWartosci[2];
                int year = Integer.valueOf(tablicaWartosci[3]);
                char cover = tablicaWartosci[4].charAt(0);
                String[] authorsId = tablicaWartosci[5].split(",");
                Lists lists = Lists.getInstance();
                List<Author> authors1 = lists.getAuthorList();
                if (authors1.isEmpty()){
                    authors = null;
                }
                for (int i = 0; i < authorsId.length; i++) {
                    int finalId = i;
                    authors.add(authors1.stream()
                            .filter(author -> author.getId() == Integer.valueOf(authorsId[finalId]))
                            .findAny().get());

                }

                Category category;
                int categoryId = Integer.valueOf(tablicaWartosci[6]);

                if (lists.getCategoryList().isEmpty()){
                    System.out.println("Lista kategorii jest pusta\n");
                    category = null;
                } else {
                    category = (lists.getCategoryList()
                            .stream()
                            .filter(c -> c.getId() == categoryId)
                            .findFirst().get());
                }
                bookList.add(new Book(id, title, isbd, year, cover, authors, category));

            }
        }catch (FileNotFoundException e){
            System.out.println("W podanej lokalizacji nie znaleziono pliku");
        }

        return bookList;
    }




}
