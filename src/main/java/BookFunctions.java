import temp.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BookFunctions {

    public Book getBookByIsbn(String isbn, List<Book> bookList) {

        return bookList.stream()
                .filter(book -> book.getIsbd().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public Book getBookByIsbn1(String isbn, List<Book> bookList) {
        Book book = new Book();
        for (Book book1 : bookList) {
            if (book1.getIsbd().equals(isbn)) {
                book = book1;
            }
        }
        return book;
    }


    public List<Book> getTwoLastBooks(List<Book> bookList) {
        if (bookList.size() > 1) {
            List<Book> temp = new ArrayList<>();
            temp.add(bookList.get(bookList.size() - 2));
            temp.add(bookList.get(bookList.size() - 1));
            return temp;
        }
        return null;
    }

    public Book getBookByPriorDate(List<Book> bookList) {
        if (!bookList.isEmpty()) {
            bookList.sort((o1, o2) -> o1.getYear() - o2.getYear());
            return bookList.get(0);
        }
        return null;
    }

    public Book getBookByLatestDate(List<Book> bookList) {
        if (!bookList.isEmpty()) {
            bookList.sort((o1, o2) -> o2.getYear() - o1.getYear());
            return bookList.get(0);
        }
        return null;
    }

    public int getSumOfYears(List<Book> bookList) {
        int sum = 0;
        if (!bookList.isEmpty()) {
            for (Book book : bookList) {
                sum += book.getYear();
            }
        }
        return sum;
    }

    public int getSumOfYears1(List<Book> bookList) {
        int sum = 0;
        if (!bookList.isEmpty()) {
            sum = bookList.stream().mapToInt(value -> value.getYear())
                    .sum();
        }
        return sum;
    }

    public long numberOfBooksAfter2007(List<Book> bookList) {
        long sum = 0;
        if (!bookList.isEmpty()) {
            sum = bookList.stream()
                    .filter(book -> book.getYear() > 2007)
                    .count();
        }
        return sum;
    }

    public boolean areAllafter2000(List<Book> bookList) {
        boolean answer = true;
        if (!bookList.isEmpty()) {
            answer = !bookList.stream()
                    .filter(book -> book.getYear() < 2000)
                    .findAny()
                    .isPresent();
        }

        return answer;
    }

    public int averageYearOfBooks(List<Book> bookList) {
        int average = 0;
        int sum;
        if (!bookList.isEmpty()) {
            sum = bookList.stream().mapToInt(value -> value.getYear())
                    .sum();
            average = sum / bookList.size();
        }

        return average;
    }

    public boolean isAnyBefor2003(List<Book> bookList) {
        if (!bookList.isEmpty()) {
            return bookList.stream()
                    .filter(book -> book.getYear() < 2003)
                    .findAny()
                    .isPresent();
        }
        return false;
    }

    public List<Book> withCfirst(List<Book> bookList) {
        if (bookList.size() > 1) {
            List<Book> temp = new ArrayList<>();
            temp = bookList.stream()
                    .filter(book -> book.getTitle().substring(0, 1).equalsIgnoreCase("C"))
                    .filter(book -> book.getYear() > 2007)
                    .collect(Collectors.toList());
            return temp;
        }
        return null;
    }

    public void add100Years(List<Book> bookList) {
        for (Book book : bookList) {
            book.setYear(book.getYear() + 100);
        }
    }

    public void add100Years1(List<Book> bookList) {
        bookList.stream()
                .forEach(book -> book.setYear(book.getYear() + 100));

    }

    public List<String> byTwo(List<Book> bookList) {

        if (!bookList.isEmpty()) {
            List<String> titleList = new ArrayList<>();
            List<Book> temp2 = new ArrayList<>();
            temp2 = bookList.stream()
                    .filter(book -> book.getYear() % 2 == 0)
                    .collect(Collectors.toList());
            titleList = temp2.stream()
                    .map(book -> book.getTitle())
                    .collect(Collectors.toList());


            return titleList;
        }
        return null;
    }
    public Map<String,Book> getMapOfBooks(List<Book> bookList){
        if (!bookList.isEmpty()) {
            Map<String, Book> bookMap = new TreeMap<>();
            for (int i = 0; i < bookList.size(); i++) {
                bookMap.put(bookList.get(i).getIsbd(), bookList.get(i));
            }
            return bookMap;
        }
        return null;
    }
    public void sortByLastYear(List<Book> bookList){
        bookList.sort((o1, o2) -> o2.getYear()-o1.getYear());
    }
    public void sortByFirstYear(List<Book> bookList){
        bookList.sort((o1, o2) -> o1.getYear()-o2.getYear());
    }
//public List<List<Book>> makeThreeList(List<Book> bookList){
//        List<Book> temp = new ArrayList<>();
//        temp = bookList.stream().map()
}

