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
    private int format =1;

    private Lists() throws IOException {
        AddAuthors addAuthors = new AddAuthors();
        AddBooks addBooks = new AddBooks();
        AddCategories addCategories = new AddCategories();
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
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
        if (authorList==null||authorList.isEmpty()){
            System.out.println("Lista autorów jest pusta\n");
            authorList = new ArrayList<>();
        }
        return authorList;
    }

    public List<Book> getBookList() {
        if (bookList==null||bookList.isEmpty()) {
            System.out.println("Lista książek jest pusta\n");
            bookList = new ArrayList<>();}
        return bookList;
    }

    public List<Category> getCategoryList() {
        if (categoryList==null){
            System.out.println("Lista kategorii jest null\n");
            categoryList = new ArrayList<>();
        }
        if (categoryList.isEmpty()){
            System.out.println("Lista kategorii jest pusta");
        }
        return categoryList;
    }
    public void showListOfBook(){
        for (Book book : bookList) {
            if (format == 1)
            System.out.println(book.getYear()+" "+book.getTitle()+" "+book.getIsbd());
            if (format == 2)
                System.out.println(book.getTitle()+" "+book.getYear()+" "+book.getIsbd());
            if (format==3)
                System.out.println(book.getIsbd()+" "+book.getTitle()+" "+book.getYear());
        }
    }

    public void setFormat(int format) {
        this.format = format;
    }
}
