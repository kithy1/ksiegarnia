package bookStore;

import bookStore.addElements.AddAuthors;
import bookStore.addElements.AddBooks;
import bookStore.addElements.AddCategories;
import bookStore.addElements.SourceFileName;
import bookStore.elements.Author;
import bookStore.elements.Book;
import bookStore.elements.Category;
import bookStore.lists.Lists;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        SourceFileName sourceFileName = new SourceFileName();

        try {
            AddCategories addCategories = new AddCategories();
            List<Category> newListOfCategories = addCategories.getNewListOfCategories(sourceFileName.getCategorySourceFileName());

            Lists lists = Lists.getInstance();
            lists.setCategoryList(newListOfCategories);

            AddAuthors addAuthors = new AddAuthors();
            List<Author> newListOfAuthors = addAuthors.getNewListOfAutors(sourceFileName.getAuthorSourceFileName());

            lists.setAuthorList(newListOfAuthors);


            AddBooks addBooks = new AddBooks();
            List<Book> newListOfBooks = addBooks.getNewListOfBooks(sourceFileName.getBookSoureceFileName());

            lists.setBookList(newListOfBooks);
        } catch (Exception e) {
            System.out.println("błąd obsługi pliku, sprawdż czy plik istnieje lub czy podano prawidłową nazwę");

        }
        Menu menu = new Menu();
        menu.menu();


    }
}
