import java.util.Scanner;

public class MaxMod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long tt = sc.nextLong();  // number of test cases

        while (tt-- > 0) {
            long n = sc.nextLong();

            if (n % 2 == 0) {
                System.out.println(-1);
            } else {
                System.out.print(n + " ");
                for (int i = 1; i <= n - 1; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
