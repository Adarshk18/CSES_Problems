import java.util.*;

public class LargeArray {

    static void solveQuery(Scanner sc) {
        int n = sc.nextInt();
        long k = sc.nextLong();
        long x = sc.nextLong();

        long[] a = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            sum += a[i];
        }

        if (x > k * sum) {
            System.out.println(0);
            return;
        }

        long xm = x % sum;
        long q = x / sum;
        if (xm == 0) {
            q--;
            xm = sum;
        }

        long ans = n * k - q * n;
        long suf = 0;
        for (int i = n - 1; i >= 0; i--) {
            suf += a[i];
            if (suf >= xm)
                break;
            ans--;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solveQuery(sc);
        }

        sc.close();
    }
}