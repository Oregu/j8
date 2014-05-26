package lam;

import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
public interface BiWithCurry<T, U, R> extends BiFunction<T, U, R> {
    default Function<U, R> curry(T t) {
        return Curry.curry(this, t);
    }
}
