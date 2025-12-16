import java.util.*;

public class CountingTowers {
    static final int MOD = 1_000_000_007;
    static final int MAX = 1_000_000;

    static long[] ans = new long[MAX + 1];


    static void precompute() {
        long full = 1, split = 1;
        ans[1] = 2;

        for (int i = 2; i <= MAX; i++) {
            long newFull = (2 * full + split) % MOD;
            long newSplit = (full + 4 * split) % MOD;

            full = newFull;
            split = newSplit;

            ans[i] = (full + split) % MOD;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        precompute();

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            System.out.println(ans[n]);
        }
    }
}
