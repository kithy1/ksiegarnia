import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Scanner;

@Getter
@Setter
public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Author(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Author() {
    }



    @Override
    public String toString() {
        return id + ";" + firstName + " " + lastName + ";"+ age;
    }

    public Author manualAuthorCreator(int id) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię:");
        firstName = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        lastName = scanner.nextLine();
        System.out.println("Podaj wiek:");
        while (true){
            try {
                age = Integer.valueOf(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Podaj liczbę lat");
            }

        }

        return new Author(id,firstName,lastName,age);
    }


}
