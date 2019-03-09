import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class BookFunctionsTest {
    List<Book> bookList = new ArrayList<>();

    BookFunctions bookFunctions = new BookFunctions();
    AddAuthors addAuthors = new AddAuthors();

    BookFunctionsTest() {
    }

    @BeforeEach
    void setUp() throws IOException {
        Book book1 = new Book(1, "Ctytuł", "132350882", 2008, 'T', null, null);
        Book book2 = new Book(2, "tytuł2", "134685997", 2006, 'T', null, null);
        Book book3 = new Book(3, "tytuł3", "321146530", 2012, 'T', null, null);
        Book book4 = new Book(4, "tytuł4", "321127420", 1999, 'T', null, null);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

    }

    @Test
    void getBookByIsbn() {
        Book bookByIsbn = bookFunctions.getBookByIsbn("132350882", bookList);
        Assert.assertEquals(bookByIsbn.getTitle(), "tytuł");
    }

    @Test
    void getBookByIsbn3() {

        Book bookByIsbn = bookFunctions.getBookByIsbn("350882", bookList);
        Assert.assertEquals(null, bookByIsbn);
    }


    @Test
    void getBookByIsbn1() {
        Book bookByIsbn = bookFunctions.getBookByIsbn1("321127420", bookList);
        Assert.assertEquals(bookByIsbn.getTitle(), "tytuł4");

    }

    @Test
    void getBookByIsbn2() {
        Book bookByIsbn = bookFunctions.getBookByIsbn1("3211274", bookList);
        Assert.assertEquals(bookByIsbn.getTitle(), null);

    }

    @Test
    void getTwoLastBooks() {
        List<Book> list = new ArrayList<>();
        list = bookFunctions.getTwoLastBooks(bookList);
        List<Book> expectedList = new ArrayList<>();
        expectedList.add(bookList.get(2));
        expectedList.add(bookList.get(3));
        Assert.assertEquals(expectedList, list);
    }

    @Test
    void getTwoLastBooks1() {
        List<Book> list = new ArrayList<>();
        bookList.clear();
        list = bookFunctions.getTwoLastBooks(bookList);
        // Assert.assertEquals(null,list);
        Assert.assertNull(list);
    }

    @Test
    void getBookByPriorDate() {
        Book book = bookFunctions.getBookByPriorDate(bookList);
        Assert.assertEquals(book.getTitle(), "tytuł4");
    }

    @Test
    void getBookByPriorDate1() {
        bookList.clear();
        Book book = bookFunctions.getBookByPriorDate(bookList);
        Assert.assertNull(book);
    }

    @Test
    void getBookByLatestDate() {
        Book book = bookFunctions.getBookByLatestDate(bookList);
        Assert.assertEquals(book.getTitle(), "tytuł3");
    }

    @Test
    void getBookByLatestDate1() {
        bookList.clear();
        Book book = bookFunctions.getBookByPriorDate(bookList);
        Assert.assertNull(book);
    }

    @Test
    void getSumOfYears() {
        int sum = bookFunctions.getSumOfYears1(bookList);
        Assert.assertEquals(8025, sum);
    }

    @Test
    void getSumOfYears1() {
        bookList.clear();
        int sum = bookFunctions.getSumOfYears1(bookList);
        Assert.assertEquals(0, sum);
    }

    @Test
    void numberOfBooksAfter2007() {
        long sum = bookFunctions.numberOfBooksAfter2007(bookList);
        Assert.assertEquals(2, sum);
    }

    @Test
    void numberOfBooksAfter20071() {
        bookList.clear();
        long sum = bookFunctions.numberOfBooksAfter2007(bookList);
        Assert.assertEquals(0, sum);
    }

    @Test
    void areAllafter2000() {
        boolean answer = bookFunctions.areAllafter2000(bookList);
        Assert.assertEquals(false, answer);
    }

    @Test
    void areAllafter20001() {
        bookList.remove(1);
        bookList.remove(2);
        boolean answer = bookFunctions.areAllafter2000(bookList);
        Assert.assertEquals(true, answer);
    }

    @Test
    void averageYearOfBooks() {
        int average = bookFunctions.averageYearOfBooks(bookList);
        Assert.assertEquals(2006, average);
    }

    @Test
    void averageYearOfBooks1() {
        bookList.clear();
        int average = bookFunctions.averageYearOfBooks(bookList);
        Assert.assertEquals(0, average);
    }

    @Test
    void withCfirst() {
        List<Book> temp = bookFunctions.withCfirst(bookList);
        List<Book> expected = new ArrayList<>();
        expected.add(bookList.get(0));
        Assert.assertEquals(expected, temp);
    }

    @Test
    void withCfirst1() {
        bookList.clear();
        List<Book> temp = bookFunctions.withCfirst(bookList);
        Assert.assertNull(temp);
    }

    @Test
    void add100Years() {
        bookFunctions.add100Years(bookList);
        Assert.assertEquals(2112, bookList.get(2).getYear());
    }

    @Test
    void add100Years1() {
        bookFunctions.add100Years(bookList);
        Assert.assertEquals(2112, bookList.get(2).getYear());
    }

    @Test
    void byTwo() {
        List<String> temp = new ArrayList<>();
        temp = bookFunctions.byTwo(bookList);
        List<String> expected = new ArrayList<>();
        expected.add("Ctytuł");
        expected.add("tytuł2");
        expected.add("tytuł3");
        Assert.assertEquals(expected,temp);
    }
    @Test
    void getMapOfBooks(){
        Map<String,Book> temp =new  TreeMap<>();
        temp=bookFunctions.getMapOfBooks(bookList);
        Map<String,Book> expected = new TreeMap<>();
        expected.put("132350882",bookList.get(0));
        expected.put("134685997",bookList.get(1));
        expected.put("321146530",bookList.get(2));
        expected.put("321127420",bookList.get(3));
        Assert.assertEquals(expected,temp);
    }
    @Test
    void sortByLastYear(){
     //   bookList.sort((o1, o2) -> o2.getYear()-o1.getYear());
    //    bookList.forEach(book -> System.out.println(book));
        List<Book> expected = new ArrayList<>();
        expected.add(bookList.get(2));
        expected.add(bookList.get(0));
        expected.add(bookList.get(1));
        expected.add(bookList.get(3));
        List<Book> temp = new ArrayList<>();
        bookFunctions.showBooksSortedByLastYear(bookList);
        Assert.assertEquals(expected,bookList);

    }
    @Test
    void saveListToCSV() throws IOException {
        Author author1 = new Author(1,"Jan","Kowalski",45);
        Author author2 = new Author(2,"Andrzej","Nowak",50);
        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        bookFunctions.saveListToCSV(authors,"test.csv");
        List<Author> resultlist = addAuthors.getNewListOfAutors("test.csv");
        Assert.assertEquals(authors.get(0).toString(),resultlist.get(0).toString());

    }

}