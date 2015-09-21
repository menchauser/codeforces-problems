import java.util.Scanner;

public class Problem158A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] results = new int[n];

        for (int i = 0; i < n; i++) {
            results[i] = scanner.nextInt();
        }

        if (results[k-1] == 0) {
            while (k > 0 && results[k-1] == 0) {
                k--;
            }
            if (k < 0) {
                System.out.println("0");
                return;
            }
        }

        int cursor = k;
        while (cursor < n && results[cursor] == results[cursor-1] && results[cursor-1] > 0) {
            cursor++;
        }

        // output the array index + 1
        System.out.println(cursor);
    }
}
