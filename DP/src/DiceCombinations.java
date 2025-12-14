import java.util.*;

public class DiceCombinations {
    static final int MOD = 1_000_000_007;

    public static int ways(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    sum = (sum + dp[i - j]) % MOD;
                }
            }
            dp[i] = (int) sum;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int sum = in.nextInt();
        System.out.println(ways(sum));

    }
}
