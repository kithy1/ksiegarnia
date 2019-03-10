package bookStore.elements;

import java.util.Scanner;

public class Category {
    private int id;
    private String name;
    private int priority;

    public Category(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public Category() {
    }
public Category manualCategoryCreator(int id){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj nazwę:");
    name = scanner.nextLine();

    System.out.println("Podaj priorytet:");
    while (true){
        try {
            priority = Integer.valueOf(scanner.nextLine());
            break;
        } catch (NumberFormatException e) {
            System.out.println("Podaj liczbę");
        }

    }
        return new Category(id,name,priority);
}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return id +";"+ name +";"+ priority;
    }
}
