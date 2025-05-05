import java.util.*;

public class SubarraySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final long NEG_INF = -1000000000000000000L;

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            String s = sc.next();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long curr = 0, M_known = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    curr = Math.max(curr + a[i], a[i]);
                    M_known = Math.max(M_known, curr);
                    if (curr < 0) curr = 0;
                } else {
                    curr = 0;
                }
            }

            if (M_known > k) {
                System.out.println("No");
                continue;
            }

            int zero_pos = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    zero_pos = i;
                    break;
                }
            }

            if (zero_pos == -1) {
                if (M_known == k) {
                    System.out.println("Yes");
                    for (long v : a) System.out.print(v + " ");
                    System.out.println();
                } else {
                    System.out.println("No");
                }
                continue;
            }

            int j = zero_pos;
            long suffix_sum = 0, Lmax = Long.MIN_VALUE;
            boolean foundL = false;
            for (int i = j - 1; i >= 0 && s.charAt(i) == '1'; i--) {
                suffix_sum += a[i];
                Lmax = Math.max(Lmax, suffix_sum);
                foundL = true;
            }
            long L = foundL ? Lmax : 0;

            long prefix_sum = 0, Rmax = Long.MIN_VALUE;
            boolean foundR = false;
            for (int i = j + 1; i < n && s.charAt(i) == '1'; i++) {
                prefix_sum += a[i];
                Rmax = Math.max(Rmax, prefix_sum);
                foundR = true;
            }
            long R = foundR ? Rmax : 0;

            long x;
            if (L >= 0 && R >= 0) {
                x = k - L - R;
            } else if (L >= 0 && R <= 0) {
                x = k - L;
            } else if (L <= 0 && R >= 0) {
                x = k - R;
            } else {
                x = k;
            }

            System.out.println("Yes");
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    if (i == j) System.out.print(x);
                    else System.out.print(NEG_INF);
                } else {
                    System.out.print(a[i]);
                }
                System.out.print((i + 1 < n ? " " : "\n"));
            }
        }

        sc.close();
    }
}
