package infer;

/**
 * Created by oregusya on 10.05.14.
 */
public class InferenceTest {
    public static void main(String[] args) {
        Lst<String> ls = Lst.nil();
        Lst.cons(42, Lst.nil());
        String s = Lst.<String>nil().head();

        Lst.processStringLst(Lst.nil());
    }
}
