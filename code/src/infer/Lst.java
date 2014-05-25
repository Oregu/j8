package infer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oregusya on 10.05.14.
 */
public class Lst<A> {
    private List<A> lst = new ArrayList<A>();

    static <Z> Lst<Z> nil() {
        return new Lst<>();
    }

    static <Z> Lst<Z> cons(Z head, Lst<Z> tail) {
        Lst<Z> l = new Lst<Z>();
        l.lst.add(head);
        l.lst.addAll(tail.lst);
        return l;
    }

    public A head() {
        return lst.get(0);
    }

    public static void processStringLst(Lst<String> l) {
        //
    }
}
