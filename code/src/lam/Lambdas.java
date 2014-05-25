package lam;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Lambdas {

    private static List<Field> fields;
    private static Map<String, List<Field>> fieldmap;

    private static void init() {
        fields = Arrays.asList(new Field("f_string", true),
                               new Field("f_int", false),
                               new Field("f_vari", true),
                               new Field("f_abc", false));

        fieldmap = new HashMap<>();
        fieldmap.put("f1", Arrays.asList(new Field("f_str", true)));
        fieldmap.put("f2", Arrays.asList(new Field("f_int", true)));
    }

    public static void main(String [] args) {
        init();

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

        names.stream().map((String s) -> { return s.length(); });
        names.stream().map((s) -> s.length());
        names.stream().map(s -> s.length());
        names.stream().map(String::length);

        names.stream().map(Field::create);
        names.stream().map(Field::new);
        names.stream().map(Object::toString);

        Function<String, Integer> ln = String::length;
        Function<String, Integer> revln = ln.andThen(Integer::reverse);
        names.stream().map(revln).forEach(out::println);

        Function<String, Integer> f = String::length;
        Function<Integer, Float> g = Integer::floatValue;
        Function h = g.compose(f);

        Function id = Function.identity();

        Map<Integer, List<String>> lenghts = names.parallelStream().collect(groupingBy(String::length));
        lenghts.forEach((key, ns) -> out.println(key + ":\t" + ns.stream().collect(joining(", "))));

//        names = fieldmap.values().stream().reduce((l, fs) -> {l.addAll(fs.stream().map(Field::getName).collect(toList())); return l;});
//        names.forEach(System.out::println);
    }
}
