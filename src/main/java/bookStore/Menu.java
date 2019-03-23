package bookStore;

import bookStore.elements.Author;
import bookStore.elements.Category;
import bookStore.functions.BookFunctions;
import bookStore.functions.BookSorter;
import bookStore.lists.Lists;

import java.io.IOException;
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
        System.out.println("11. Edytowanie nazwy kategorii");
        System.out.println("12. Wyświetl książki według nazwy kategorii");
        System.out.println("13. Wyświetl książki według nazwiska autora");
        System.out.println("14. Wyświetl wg. tytuł, rok, isbn");
        System.out.println("15. Wyświetl wg. isbn, tytuł, rok");
        System.out.println("16. Wyświetl wg. rok, tytuł, isbn");
        System.out.println("20. Zakończ");
        System.out.println("...................");
    }

    public void menu() throws IOException {
        Lists lists = Lists.getInstance();
        Author author;
        BookFunctions bookFunctions = new BookFunctions();
        Category category;
        int choice;
        Scanner scanner = new Scanner(System.in);
        String stop;
        do {
            showMenu();
            System.out.println("podaj numer");

            try {
                choice = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }


            switch (choice) {
                case 1:
                    lists.showListOfBook();
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 2:
                    lists.getAuthorList().forEach(System.out::println);
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 3:
                    lists.getCategoryList().forEach(System.out::println);
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 4:
                    int id = bookFunctions.firstFreeIdOfAuthorGenerator(lists.getAuthorList());
                    author = new Author().manualAuthorCreator(id);
                    lists.getAuthorList().add(author);
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 5:
                    int id1 = bookFunctions.firstFreeIdOfCathegoryGenerator(lists.getCategoryList());
                    category = new Category().manualCategoryCreator(id1);
                    lists.getCategoryList().add(category);
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 6:
                    bookFunctions.saveListToCSV(lists.getAuthorList(), "authors.csv");
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 7:
                    bookFunctions.saveListToCSV(lists.getCategoryList(), "categories.csv");
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 8:
                    bookFunctions.showBooksSortedByFirstYear(lists.getBookList());
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 9:
                    bookFunctions.showBooksSortedByLastYear(lists.getBookList());
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 10:
                    bookFunctions.listOfBooksPublishedAfter2003(lists.getBookList());
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 11:
                    System.out.println("Podaj id kategorii, której nazwę chcesz zmienić");
                    int id2;
                    try {
                        id2 = Integer.valueOf(scanner.nextLine());
                        category = bookFunctions.editCategoryName(lists.getCategoryList(), id2);
                        lists.getCategoryList().remove(id2 - 1);
                        lists.getCategoryList().add(id2 - 1, category);
                    } catch (NumberFormatException e) {
                        System.out.println("Wpisz id kategori w formacie liczbowym");
                    }
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 12:
                    String categoryName = scanner.nextLine();
                    bookFunctions.showByCategory(lists.getBookList(), categoryName);
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 13:
                    String authorLastName = scanner.nextLine();
                    bookFunctions.showByAuthor(lists.getBookList(), authorLastName);
                    System.out.println("Wciśnij enter aby kontynuować");
                    stop = scanner.nextLine();
                    break;
                case 14:
                    lists.setFormat(2);
                    break;
                case 15:
                    lists.setFormat(3);
                    break;
                case 16:
                    lists.setFormat(1);
                    break;
                case 20:
                    break;
                default:
                    System.out.println("wpisano niewłaściwy znak");
                    showMenu();

            }
        } while (choice != 20);


    }
}
