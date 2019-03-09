package bookStore.lists;

import bookStore.elements.Author;
import bookStore.elements.Book;
import bookStore.elements.Category;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    private List<Author> authorList;
    private List<Book> bookList;
    private List<Category> categoryList;

    public Lists(){
        authorList = new ArrayList<>();
        bookList = new ArrayList<>();
        categoryList = new ArrayList<>();
    }

    public List<Author> getAuthorList(){
        return authorList;
    }
    public List<Book> getBookList(){
        return bookList;
    }
    public List<Category> getCategoryList(){
        return categoryList;
    }
}
