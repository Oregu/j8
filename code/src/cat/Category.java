package cat;

import java.util.function.Function;

public interface Category {
    <A> A id(A a);
    <A, B, C> Function<A, C> compose(Function<B, C> g, Function<A, B> f);
}
