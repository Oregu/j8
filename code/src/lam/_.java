package lam;

import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public interface _ {
    static <T,U,R> Function<T, Function<U, R>> curry(BiFunction<T, U, R> bi) {
        return t -> u -> bi.apply(t ,u);
    }

    static <T,U,R> Function<U, R> partial(BiFunction<T, U, R> bi, T t) {
        return u -> bi.apply(t ,u);
    }

    static <CT extends List<T>, T, R> List<R> map(Function<T, R> f, CT coll) {
        return coll.stream().map(f).collect(toList());
    }
}
