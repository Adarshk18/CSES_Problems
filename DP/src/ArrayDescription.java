import java.util.*;

public class ArrayDescription {
    static final int MOD = 1000000007;

    static int ways(int[] x, int n, int m) {
        int[] prev = new int[m + 2];
        int[] curr = new int[m + 2];

        if (x[0] == 0) {
            for (int v = 1; v <= m; v++) prev[v] = 1;
        } else {
            prev[x[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            Arrays.fill(curr, 0);

            for (int v = 1; v <= m; v++) {
                if (x[i] != 0 && x[i] != v) continue;

                long ways = prev[v];
                ways = (ways + prev[v - 1]) % MOD;
                ways = (ways + prev[v + 1]) % MOD;

                curr[v] = (int) ways;
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        long ans = 0;
        for (int v = 1; v <= m; v++) ans = (ans + prev[v]) % MOD;

        return (int) ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        System.out.println(ways(a,n,m));
    }
}
