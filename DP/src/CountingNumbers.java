import java.io.*;
import java.util.*;

public class CountingNumbers {

    static List<Integer> digits;
    static long[][][][] dp;
    static int n;


    static long dfs(int pos, int prevDigit, int tight, int leadingZero) {
        if (pos == n) {
            return 1;
        }

        if (dp[pos][prevDigit][tight][leadingZero] != -1) {
            return dp[pos][prevDigit][tight][leadingZero];
        }

        long res = 0;
        int limit = (tight == 1) ? digits.get(pos) : 9;

        for (int d = 0; d <= limit; d++) {


            if (leadingZero == 0 && d == prevDigit) continue;

            int nextTight = (tight == 1 && d == limit) ? 1 : 0;
            int nextLeadingZero = (leadingZero == 1 && d == 0) ? 1 : 0;

            int nextPrev;
            if (nextLeadingZero == 1)
                nextPrev = 10;
            else
                nextPrev = d;

            res += dfs(pos + 1, nextPrev, nextTight, nextLeadingZero);
        }

        return dp[pos][prevDigit][tight][leadingZero] = res;
    }

    static long solve(long x) {
        if (x < 0) return 0;

        digits = new ArrayList<>();
        while (x > 0) {
            digits.add((int)(x % 10));
            x /= 10;
        }
        Collections.reverse(digits);

        n = digits.size();
        dp = new long[n][11][2][2];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < 11; j++)
                for (int k = 0; k < 2; k++)
                    Arrays.fill(dp[i][j][k], -1);

        return dfs(0, 10, 1, 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        long L = Long.parseLong(parts[0]);
        long R = Long.parseLong(parts[1]);

        long ans = solve(R) - solve(L - 1);
        System.out.println(ans);
    }
}
