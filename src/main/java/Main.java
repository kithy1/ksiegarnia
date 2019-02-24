import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        AddBooks addBooks = new AddBooks();
        AddAuthors addAuthors = new AddAuthors();
        AddCategories addCategories = new AddCategories();

        int choice = 0;
        System.out.println("Menu");
        System.out.println("1. Lista Książek");
        System.out.println("2. Lista Autorów");
        System.out.println("3. Lista Kategorii");
        System.out.println("4. Zakończ");



        while (choice != 4) {
            System.out.println("podaj numer");
            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("nie wczytano liczby");
                System.out.println("Wpisz:");
                System.out.println("1. aby wyświetlić");
                System.out.println("2. aby zakończyć");
            }

            switch (choice) {
                case 1:
                    addBooks.getNewListOfBooks().forEach(x-> System.out.println(x));
                    break;
                case 2:
                    addAuthors.getNewListOfAutors().forEach(x-> System.out.println(x));
                    break;
                case 3:
                    addCategories.getNewListOfCategories().forEach(x-> System.out.println(x));
                    break;
                case 4:
                    break;
                default:
                    System.out.println("podano inną cyfrę");
            }

        }


//        Book book1 = addBooks.getNewListOfBooks().get(0);
//        Book book2 = addBooks.getNewListOfBooks().get(1);
//        System.out.println(book1.toString());
//        System.out.println(book2.toString());




    }
}
