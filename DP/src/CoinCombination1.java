import java.util.*;

public class CoinCombination1 {
    static final int MOD = 1_000_000_007;

    public static int distinctWays(int[] arr, int sum) {

        int[] prev = new int[sum + 1];

        prev[0] = 1; //as there is 1 way to make sum as zero to choose nothing

        for (int s = 1; s <= sum; s++) {
            for (int a : arr) {
                if (s >= a) {
                    prev[s] = (prev[s] + prev[s - a]) % MOD;
                }
            }


        }
        return prev[sum];

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int ans = distinctWays(arr, sum);
        System.out.println(ans);
    }
}