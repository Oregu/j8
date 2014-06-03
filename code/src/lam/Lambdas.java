package lam;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Lambdas {

    private static List<Field> fields;
    private static Map<String, List<Field>> fieldmap;

    static {
        fields = Arrays.asList(new Field("f_string", true),
                               new Field("f_int", false),
                               new Field("f_vari", true),
                               new Field("f_abc", false));

        fieldmap = new HashMap<>();
        fieldmap.put("f1", Arrays.asList(new Field("f_str", true), new Field("f_abc", true)));
        fieldmap.put("f2", Arrays.asList(new Field("f_int", true)));
    }

    public static void main(String [] args) {

        // Reduce boilerplate
        List<String> names = new ArrayList<String>();
        for (int i = 0; i < fields.size(); i++) {
            Field fld = fields.get(i);
            names.add(fld.getName());
        }
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            out.println(name);
        }

        names = fields.stream().map(Field::getName).collect(toList());
        names.forEach(out::println);

        // Collection in collection
        names = fieldmap.values().stream().collect(
                ArrayList<String>::new,
                (l, fs) -> l.addAll(fs.stream().map(Field::getName).collect(toList())),
                ArrayList<String>::addAll);
        out.println("\n2Dcollected:");
        names.forEach(System.out::println);

        // Lambda syntax
        names.stream().map((String s) -> { return s.length(); });
        names.stream().map((s) -> s.length());
        names.stream().map(s -> s.length());
        names.stream().map(String::length);

        names.stream().map(Field::create);
        names.stream().map(Field::new);
        names.stream().map(Object::toString);

        // Functional interface
        Function<String, Integer> ln = String::length;
        Function<String, Integer> revln = ln.andThen(Integer::reverse);
        names.stream().map(revln).forEach(out::println);

        // Composition
        Function<String, Integer> f = String::length;
        Function<Integer, Float> g = Integer::floatValue;
        Function h = g.compose(f);

        Function id = Function.identity();

        // Curry
        IntFunction<IntUnaryOperator> sum = a -> b -> a + b;
        IntUnaryOperator add6 = sum.apply(6);
        out.println(add6.applyAsInt(10));
        out.println(add6.applyAsInt(11));

        Function<String, UnaryOperator<String>> curried = s1 -> s2 -> s1.concat(" ").concat(s2);

        // Functional Application
        UnaryOperator<String> hask = curried.apply("Haskell");
        out.println(hask.apply("Curry"));
        out.println(hask.apply("Wexler"));

        // Curry any?
        BiFunction<String, Integer, Float> bi = (s, i) -> (s.length() + i)/2.0f;
        // Can't do bi.curry("hello");

        Function <Integer, Float> part = _.partial(bi, "hello");
        // Or the same:
        // Function <Integer, Float> part = _.curry(bi).apply("hello");

        // Will we be able call fc(7) someday?
        out.println(part.apply(10));
        out.println(part.apply(22));

        // Parallel
        Map<Integer, List<String>> lns = names.parallelStream().collect(groupingBy(String::length));
        lns.forEach((key, ns) -> out.println(key + ":\t" + ns.stream().collect(joining(", "))));
    }
}
