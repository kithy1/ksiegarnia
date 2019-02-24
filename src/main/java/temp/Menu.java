package temp;

import java.util.Scanner;

public class Menu {

    public void menu(){
        int choice = 0;
        System.out.println("Menu");
        System.out.println("1. Wyświetl");
        System.out.println("2. Zakończ");

        while (choice != 2) {

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
                    System.out.println("wejście");
                    break;
                case 2:
                    break;
                default:
                    System.out.println("podano inną cyfrę");
            }

        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();
    }
}
