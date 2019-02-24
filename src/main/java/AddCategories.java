import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AddCategories {
    public List<Category> getNewListOfCategories() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("categories.csv"));
        List<String> dataList = new ArrayList<>();
        lines.forEach(x -> dataList.add(x));
        List<Category> categoriesList = new ArrayList<>();
        for (String s : dataList) {
            String[] split = s.split(";");
            int id = Integer.valueOf(split[0]);
            String name = split[1];
            int priority = Integer.valueOf(split[2]);
            categoriesList.add(new Category(id,name,priority));

        }

        return categoriesList;
    }
}
