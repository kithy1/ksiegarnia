package temp;

import javax.swing.*;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        int choice = 0;
        JOptionPane.showMessageDialog(null,"Menu\n" +
                "1. Wyświetl\n2. Zakończ");


        while (choice!=2){

            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.valueOf(JOptionPane.showInputDialog("wpisz cyfrę"));
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"nie wczytano liczby\nWpisz:\n" +
                        "1. aby wyświetlić\n2. aby zakończyć");

            }

            switch (choice){
                case 1:
                    JOptionPane.showMessageDialog(null,"wejście");
                    break;
                case 2:
                    break;
                    default:
                        JOptionPane.showMessageDialog(null,"podano nieprawidłową cyfrę");
            }

        }
    }
}
