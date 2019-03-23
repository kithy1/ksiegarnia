package bookStore;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list = Arrays.asList(new int[]{1,2,3});
        List cos = Arrays.asList(new Integer[]{1,2,3});
        System.out.println(list.size()==cos.size());
    }
}
