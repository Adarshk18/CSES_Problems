import java.util.*;

public class RectangleCutting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();

        int[][] dp = new int[A + 1][B + 1];


        for (int a = 1; a <= A; a++) {
            for (int b = 1; b <= B; b++) {
                if (a == b) {
                    dp[a][b] = 0;
                    continue;
                }
                int ans = Integer.MAX_VALUE;

                //Horizontal
                for (int i = 1; i < a; i++) {
                    ans = Math.min(ans, 1 + dp[i][b] + dp[a - i][b]);
                }

                for (int i = 1; i < b; i++) {
                    ans = Math.min(ans, 1 + dp[a][i] + dp[a][b - i]);
                }

                dp[a][b] = ans;
            }

        }

        System.out.println(dp[A][B]);
    }
}
