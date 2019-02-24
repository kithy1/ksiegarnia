import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AddAuthors {

    public List<Author> getNewListOfAutors() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("authors.csv"));
        List<String> dataList = new ArrayList<>();
        lines.forEach(x-> dataList.add(x));
        List<Author> authorList = new ArrayList<>();
        for (String s : dataList) {
            String[] split = s.split(";");
            int id = Integer.valueOf(split[0]);
            String[] name = split[1].split(" ");
            String ferstName = name[0];
            if (name.length>2){
                for (int i = 1; i <name.length-1 ; i++) {
                    ferstName +=" "+name[i];
                }
            }
            String lastName = name[name.length-1];
            int age = Integer.valueOf(split[2]);

            authorList.add(new Author(id,ferstName,lastName,age));
        }
        return authorList;
    }
}
