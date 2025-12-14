import java.util.Arrays;
import java.util.Scanner;

public class Combination2 {
    static final int MOD = 1_000_000_007;

    static int countWaysOptimized(int[] coins, int x) {
        int[] dp = new int[x + 1];
        dp[0] = 1;


        for (int coin : coins) {

            for (int j = coin; j <= x; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % MOD;
            }
        }

        return dp[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.println(countWaysOptimized(coins, x));
    }
}
