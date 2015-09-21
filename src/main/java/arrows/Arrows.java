package arrows;

import java.util.function.BiFunction;
import java.util.function.Function;

public final class Arrows {

    // (b -> c) >>> (c -> d) ==> (b -> d)
    public static <B, C, D> Function<B, D> compose(Function<B, C> larrow, Function<C, D> rarrow) {
        return b -> rarrow.apply(larrow.apply(b));
    }

    // first (b -> c) ==> (b, d) -> (c, d)
    public static <B, C, D> Function<Pair<B, D>, Pair<C, D>> first(Function<B, C> arrow) {
        return bdPair -> pair(arrow.apply(bdPair.first), bdPair.second);
    }

    // second (b -> c) ==> (d, b) -> (d, c)
    public static <B, C, D> Function<Pair<D, B>, Pair<D, C>> second(Function<B, C> arrow) {
        return bdPair -> pair(bdPair.first, arrow.apply(bdPair.second));
    }

    // split ==> (b -> (b, b))
    public static <B> Function<B, Pair<B, B>> split() {
        return b -> pair(b, b);
    }

    // unsplit (b -> c -> d) ==> ((b, c) -> d)
    public static <B, C, D> Function<Pair<B, C>, D> unsplit(BiFunction<B, C, D> biFunction) {
        return bcPair -> biFunction.apply(bcPair.first, bcPair.second);
    }

    // (b -> c) *** (d -> e) = (b, d) -> (c, e)
    public static <B, C, D, E> Function<Pair<B, D>, Pair<C, E>> combineMult(Function<B, C> larrow, Function<D, E> rarrow) {
        return compose(first(larrow), second(rarrow));
    }

    // (b -> c) &&& (b -> d) ==> (b -> (c, d))
    public static <B, C, D> Function<B, Pair<C, D>> combineAnd(Function<B, C> larrow, Function<B, D> rarrow) {
        return
            compose(
                compose(
                    split(),
                    first(larrow)),
                second(rarrow));
    }

    // liftA2 ((b -> c -> d), (e -> b), (e -> c)) ==> e -> d
    public static <B, C, D, E> Function liftA2(BiFunction<B, C, D> biFunction, Function<E, B> larrow, Function<E, C> rarrow) {
        return
            compose(
                compose(
                    compose(
                        split(),
                        first(larrow)),
                    second(rarrow)),
                unsplit(biFunction));
    }

    public static <B, C> Pair<B, C> pair(B fst, C snd) {
        return new Pair<>(fst, snd);
    }

    public static final class Pair<B, C> {
        private final B first;
        private final C second;

        public Pair(B first, C second) {
            this.first = first;
            this.second = second;
        }
    }

}
