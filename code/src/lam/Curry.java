package lam;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface Curry {
    static <T,U,R> Function<U, R> curry(BiFunction<T, U, R> bi, T t) {
        return u -> bi.apply(t ,u);
    }
}
