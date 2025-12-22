import java.util.*;

public class MountainRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] h = new long[n];

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextLong();
        }

        // dp[i] = maximum mountains starting from i
        int[] dp = new int[n];
        int maxAns = 1;

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;

            // Use a stack to efficiently find reachable positions
            // We want to find all j > i where h[i] > h[j] and h[i] > max(h[i+1..j-1])
            Stack<Integer> stack = new Stack<>();
            long maxSeen = 0;

            for (int j = i + 1; j < n; j++) {
                // Check if we can reach j from i
                if (h[i] > h[j] && h[i] > maxSeen) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }

                // Update the maximum seen so far
                maxSeen = Math.max(maxSeen, h[j]);

                // Early termination: if maxSeen >= h[i], we can't reach anything beyond
                if (maxSeen >= h[i]) {
                    break;
                }
            }

            maxAns = Math.max(maxAns, dp[i]);
        }

        System.out.println(maxAns);
        sc.close();
    }
}