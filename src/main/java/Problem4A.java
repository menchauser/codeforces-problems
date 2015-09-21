import java.util.Scanner;
import java.util.stream.Stream;

public class Problem4A {
    public static void main(String[] args) {
        long input = Stream.of(System.in).map(Scanner::new).map(Scanner::nextLong).findFirst().get();

        if (input <= 2) {
            System.out.println("NO");
            return;
        }

        if (input % 2 != 0) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }
}
