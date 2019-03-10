package bookStore.functions;

import bookStore.addElements.AddCategories;
import bookStore.elements.Author;
import bookStore.elements.Book;
import bookStore.elements.Category;
import bookStore.lists.Lists;

import java.io.*;
import java.util.*;
import java.util.stream.Collector;
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

    public boolean isAnyAfter2003(List<Book> bookList) {
        if (!bookList.isEmpty()) {
            return bookList.stream()
                    .filter(book -> book.getYear() > 2003)
                    .findAny()
                    .isPresent();
        }
        return false;
    }
    public void listOfBooksPublishedAfter2003(List<Book> bookList){
        List<Book> list = new ArrayList<>();
        if (!bookList.isEmpty()){
            list = bookList.stream()
                    .filter(book -> book.getYear() > 2003)
                    .collect(Collectors.toList());
        }
        list.forEach(System.out::println);
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
    public void showBooksSortedByLastYear(List<Book> bookList){
        List<Book> sortedByLastYearBookList = new ArrayList<>();
        sortedByLastYearBookList.addAll(bookList);
        sortedByLastYearBookList.sort((o1, o2) -> o2.getYear()-o1.getYear());
        sortedByLastYearBookList.forEach(System.out::println);
    }
    public void showBooksSortedByFirstYear(List<Book> bookList){
        List<Book> sortedByFirstYearBookList = new ArrayList<>();
        sortedByFirstYearBookList.addAll(bookList);
        sortedByFirstYearBookList.sort(Comparator.comparingInt(Book::getYear));
        sortedByFirstYearBookList.forEach(System.out::println);
    }
//public List<List<bookStore.elements.Book>> makeThreeList(List<bookStore.elements.Book> bookList){
//        List<bookStore.elements.Book> temp = new ArrayList<>();
//        temp = bookList.stream().map()
    public <T> void saveListToCSV(List<T> list, String fileName) throws IOException {
        if(fileName==null){
            System.out.println("Nazwa pliku nie może być null'em");
            return;
        }
        File file = new File(fileName);
        if(!((fileName.substring(fileName.length()-4).equals(".csv")||(fileName.substring(fileName.length()-4).equals(".txt")))))
        {
            fileName = fileName+".csv";
        }
//        if(!fileName.substring(fileName.length()-4).equals(".")){
//           char[] temp= fileName.toCharArray();
//           for (int)
//            fileName=fileName+".csv";
//        }
        if(!file.isFile()) {
            try{
                file.createNewFile();
                System.out.println("Utworzono nowy plik o nazwie "+fileName);
            }catch (IOException e){
                System.out.println("błąd w trakcie tworzenia pliku");
            }
        }
        int listSize = list.size();
        try (Writer fileWriter = new FileWriter(fileName, false)){
            for (int i = 0; i < listSize ; i++) {
                fileWriter.write(String.valueOf(list.get(i)));
                if (i != listSize - 1) {
                    fileWriter.write("\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        }
    }
    public Category editCategoryName(List<Category> categoryList,int id){
     Category category =  categoryList.stream()
             .filter(category1 -> category1.getId()==id)
             .findFirst().get();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz nową nazwę kategorii");
        String newCategoryName = scanner.nextLine();
        category.setName(newCategoryName);
        return category;


    }
    public void showByCategory(List<Book> bookList,String categoryName){
        List<Book> selectedBooks = bookList.stream()
                .filter(book -> book.getCategory().getName().equalsIgnoreCase(categoryName))
                .collect(Collectors.toList());
        if (selectedBooks.isEmpty()){
            System.out.println("Nie znaleziono książek podanej kategorii");
        } else selectedBooks.forEach(System.out::println);

    }
    public void showByAuthor(List<Book> bookList,String authorLastName){
        List<Book> selectedBooks = new ArrayList<>();
        Author author = new Author();
        author.setLastName(authorLastName);
        for (Book book : bookList) {
            for (int i = 0; i < book.getAuthor().size() ; i++) {
                if (book.getAuthor().get(i).getLastName().equalsIgnoreCase(author.getLastName()))
                    selectedBooks.add(book);
            }
        }
        if (selectedBooks.isEmpty()){
            System.out.println("Nie znaleziono książek podanego autora");
        } else selectedBooks.forEach(System.out::println);


    }




}

