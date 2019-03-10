package bookStore.lists;

import bookStore.addElements.AddAuthors;
import bookStore.addElements.AddBooks;
import bookStore.addElements.AddCategories;
import bookStore.elements.Author;
import bookStore.elements.Book;
import bookStore.elements.Category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lists {
    private static Lists instance;

    private List<Author> authorList;
    private List<Book> bookList;
    private List<Category> categoryList;

    private Lists() throws IOException {
        AddAuthors addAuthors = new AddAuthors();
        AddBooks addBooks = new AddBooks();
        AddCategories addCategories = new AddCategories();
        authorList = addAuthors.getNewListOfAutors("authors.csv");
        bookList = addBooks.getNewListOfBooks("books.csv");
        categoryList = addCategories.getNewListOfCategories("categories.csv");

    }



    public static Lists getInstance() throws IOException {
        if (instance == null) {
            synchronized (Lists.class) {
                if (instance == null) {
                    instance = new Lists();
                }
            }
        }
        return instance;
    }


    public List<Author> getAuthorList()  {

        return authorList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }
}
