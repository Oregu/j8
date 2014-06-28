package lam;

import java.util.ArrayList;
import java.util.List;

public class UnderscoreTest {
    public static void main(String[] args) {
        ArrayList<Field> fields = new ArrayList<Field>() {{
            add(new Field("a"));
            add(new Field("b"));
        }};

        List<String> names = _.map(Field::getName, fields);
        names.forEach(System.out::println);
    }
}
