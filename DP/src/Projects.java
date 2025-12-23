import java.util.*;

public class Projects {

    // DP function: maximum money from index i onward
    public static long maxMoney(int n, long[] reward, int[] next) {
        long[] dp = new long[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            // Option 1: skip this project
            long skip = dp[i + 1];

            // Option 2: take this project and jump to next non-overlapping
            long take = reward[i] + dp[next[i]];

            dp[i] = Math.max(skip, take);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // projects[i] = {start, end, reward}
        int[][] projects = new int[n][3];

        for (int i = 0; i < n; i++) {
            projects[i][0] = in.nextInt(); // start day
            projects[i][1] = in.nextInt(); // end day
            projects[i][2] = in.nextInt(); // reward
        }

        // 1️⃣ Sort projects by start day
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));

        long[] reward = new long[n];
        int[] next = new int[n];
        int[] startTimes = new int[n];

        for (int i = 0; i < n; i++) {
            startTimes[i] = projects[i][0];
            reward[i] = projects[i][2];
        }

        // 2️⃣ Find next non-overlapping project using binary search
        for (int i = 0; i < n; i++) {
            int lo = i + 1, hi = n - 1;
            int ans = n;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                // STRICT > because days are inclusive
                if (startTimes[mid] > projects[i][1]) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            next[i] = ans;
        }

        // 3️⃣ DP to get maximum reward
        long result = maxMoney(n, reward, next);
        System.out.println(result);

        in.close();
    }
}
