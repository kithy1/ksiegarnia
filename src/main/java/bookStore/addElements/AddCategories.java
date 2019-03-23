package bookStore.addElements;

import bookStore.elements.Category;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AddCategories {
    public List<Category> getNewListOfCategories(String fileName) throws IOException {
        List<Category> categoriesList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(fileName))){
            List<String> dataList = new ArrayList<>();
            lines.forEach(x -> dataList.add(x));
            for (String s : dataList) {
                String[] split = s.split(";");
                int id = Integer.valueOf(split[0]);
                String name = split[1];
                int priority = Integer.valueOf(split[2]);
                categoriesList.add(new Category(id, name, priority));

            }
        }catch (FileNotFoundException e){
            System.out.println("W podanej lokalizacji nie znaleziono pliku");
        }

        return categoriesList;
    }
}
