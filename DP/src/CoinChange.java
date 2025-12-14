import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static int cc(int[] coins, int x){
        int INF = (int)1e9;
        int[] dp = new int[x+1];
        Arrays.fill(dp,INF);

        dp[0] = 0;
        for (int i = 0; i <= x; i++) {
            for(int c: coins){
                if (i >= c){
                    dp[i] = Math.min(dp[i], 1+dp[i-c]);
                }
            }
        }
        return dp[x] >= INF ? -1:dp[x];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int ans = cc(arr,sum);
        System.out.println(ans);
    }
}
