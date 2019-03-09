package bookStore;

import bookStore.addElements.AddAuthors;
import bookStore.addElements.AddBooks;
import bookStore.addElements.AddCategories;
import bookStore.elements.Author;
import bookStore.elements.Book;
import bookStore.elements.Category;
import bookStore.functions.BookFunctions;
import bookStore.lists.Lists;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {


    public void showMenu() {
        System.out.println("bookStore.Menu");
        System.out.println("1. Lista Książek");
        System.out.println("2. Lista Autorów");
        System.out.println("3. Lista Kategorii");
        System.out.println("4. Dodaj Autora");
        System.out.println("5. Dodaj Kategorię");
        System.out.println("6. Zapisz listę autorów do pliku csv");
        System.out.println("7. Zapisz listę kategorii do pliku csv");
        System.out.println("8. Sortowanie książek po roku wydania rosnąco");
        System.out.println("9. Sortowanie książek po roku wydania malejąco");
        System.out.println("10. Lista książek wydanych po 2003 r.");
        System.out.println("11. Zakończ");
        System.out.println("...................");
    }

    public void menu() throws IOException {
        AddBooks addBooks = new AddBooks();
        List<Book> bookList = addBooks.getNewListOfBooks();
        AddAuthors addAuthors = new AddAuthors();
        AddCategories addCategories = new AddCategories();
        Author author = null;
        Lists lists = new Lists();
        lists.getAuthorList().addAll(addAuthors.getNewListOfAutors("authors.csv"));
        lists.getCategoryList().addAll(addCategories.getNewListOfCategories("categories.csv"));
        BookFunctions bookFunctions = new BookFunctions();
        Category category = null;

        int choice = 0;

        do {
            showMenu();
            System.out.println("podaj numer");
            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }


            switch (choice) {
                case 1:
                    bookList.forEach(System.out::println);
                    break;
                case 2:
                    lists.getAuthorList().forEach(System.out::println);
                    break;
                case 3:
                    lists.getCategoryList().forEach(System.out::println);
                    break;
                case 4:
                    int id = lists.getAuthorList().size()+1;
                    author = new Author().manualAuthorCreator(id);
                    lists.getAuthorList().add(author);
                    break;
                case 5:
                    int id1 = lists.getCategoryList().size()+1;
                    category = new Category().manualCategoryCreator(id1);
                    lists.getCategoryList().add(category);
                    break;
                case 6:
                    bookFunctions.saveListToCSV(lists.getAuthorList(),"authors.csv");
                    break;
                case 7:
                    bookFunctions.saveListToCSV(lists.getCategoryList(),"categories.csv");
                    break;
                case 8:
                    bookFunctions.showBooksSortedByFirstYear(bookList);
                    break;
                case 9:
                    bookFunctions.showBooksSortedByLastYear(bookList);
                    break;
                case 10:
                    bookFunctions.listOfBooksPublishedAfter2003(bookList);
                    break;
                case 11:
                    break;
                default:
                    System.out.println("wpisano niewłaściwy znak");
                    showMenu();

            }
        } while (choice != 11);


    }
}
