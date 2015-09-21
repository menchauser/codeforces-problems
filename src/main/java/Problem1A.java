import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Problem1A {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Integer[] inputs = Stream.generate(scanner::nextInt).limit(3).toArray(Integer[]::new);
        Stream.of(inputs)
                .limit(2)
                .map(Double::valueOf)
                .map(val -> val / inputs[2])
                .map(Math::ceil)
                .reduce((m, n) -> m * n)
                .map(Math::round)
                .ifPresent(System.out::println);
    }
}

