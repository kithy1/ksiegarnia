import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Menu {


    public void showMenu() {
        System.out.println("Menu");
        System.out.println("1. Lista Książek");
        System.out.println("2. Lista Autorów");
        System.out.println("3. Lista Kategorii");
        System.out.println("4. Dodaj Autora");
        System.out.println("5. Dodaj Kategorię");
        System.out.println("6. Zapisz listę autorów do pliku csv");
        System.out.println("7. Zakończ");
        System.out.println("...................");
    }

    public void menu() throws IOException {
        AddBooks addBooks = new AddBooks();
        AddAuthors addAuthors = new AddAuthors();
        AddCategories addCategories = new AddCategories();
        Author author = null;
        AuthorList authorList = new AuthorList();
        authorList.getAuthorList().addAll(addAuthors.getNewListOfAutors());

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
                    addBooks.getNewListOfBooks().forEach(x -> System.out.println(x));
                    break;
                case 2:
                   // addAuthors.getNewListOfAutors().forEach(x -> System.out.println(x));
                      authorList.getAuthorList().forEach(author1 -> System.out.println(author1));
                    break;
                case 3:
                    addCategories.getNewListOfCategories().forEach(x -> System.out.println(x));
                    break;
                case 4:
                    author = new Author().manualAuthorCreator();
                    authorList.getAuthorList().add(author);
                    break;
                case 5:
                    break;
                case 6:
                    Writer fileWriter = new FileWriter("authors.csv",false);
//                    fileWriter.write("\n");
//                    fileWriter.write(String.valueOf(author));
                    for (int i = 0; i <authorList.getAuthorList().size() ; i++) {
                        fileWriter.write(String.valueOf(authorList.getAuthorList().get(i)));
                        if(i!=authorList.getAuthorList().size()-1){
                            fileWriter.write("\n");
                        }
                    }
                    fileWriter.close();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("wpisano niewłaściwy znak");
                    showMenu();

            }
        } while (choice != 7);


    }
}
