import java.util.Scanner;

public class StairGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] p = new long[n];

            for (int i = 0; i < n; i++) {
                p[i] = scanner.nextLong();
            }

            long xor = 0;
            for (int i = 1; i < n; i++) {
                if (p[i] % 2 != 0) {
                    xor ^= i;
                }
            }

            System.out.println(xor != 0 ? "first" : "second");
        }
    }
}
