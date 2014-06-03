package lam;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface _ {
    static <T,U,R> Function<T, Function<U, R>> curry(BiFunction<T, U, R> bi) {
        return t -> u -> bi.apply(t ,u);
    }

    static <T,U,R> Function<U, R> partial(BiFunction<T, U, R> bi, T t) {
        return u -> bi.apply(t ,u);
    }
}
