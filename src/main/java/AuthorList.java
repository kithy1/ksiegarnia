import java.util.ArrayList;
import java.util.List;

public class AuthorList {

    private List<Author> authorList;

    public AuthorList(){
        authorList = new ArrayList<>();
    }
    public List<Author> getAuthorList(){
        return authorList;
    }
}
