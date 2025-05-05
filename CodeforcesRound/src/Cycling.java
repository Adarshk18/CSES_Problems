import java.util.*;

public class Cycling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }


            long[] dp = new long[n + 1];
            Arrays.fill(dp, Long.MAX_VALUE);
            dp[n] = 0;


            for (int pos = n - 1; pos >= 0; pos--) {
                // Copy array for this position
                long[] curr = a.clone();


                if (dp[pos + 1] != Long.MAX_VALUE) {
                    dp[pos] = dp[pos + 1] + curr[pos];
                }


                for (int i = pos; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        // Swap a[i] and a[j]
                        long temp = curr[i];
                        curr[i] = curr[j];
                        curr[j] = temp;
                        long swapCost = j - i;


                        if (dp[pos + 1] != Long.MAX_VALUE) {
                            long cost = dp[pos + 1] + curr[pos] + swapCost;
                            dp[pos] = Math.min(dp[pos], cost);
                        }


                        temp = curr[i];
                        curr[i] = curr[j];
                        curr[j] = temp;
                    }
                }
            }

            System.out.println(dp[0]);
        }

        sc.close();
    }
}