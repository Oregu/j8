package lam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class UnderscoreTest {
    public static void main(String[] args) {
        curry();
        map();
    }

    private static void curry() {
        IntFunction<IntUnaryOperator> currySum = _.curry((int a, int b) -> a+b);
        IntUnaryOperator sumWith7 = currySum.apply(7);

        System.out.println(sumWith7.applyAsInt(5));
    }

    private static void map() {
        ArrayList<Field> fields = new ArrayList<Field>() {{
            add(new Field("a"));
            add(new Field("b"));
        }};

        List<String> names = _.map(Field::getName, fields);
        names.forEach(System.out::println);
    }
}
