import java.util.*;

public class MovingRobots {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = 8;
        double[][][][] dp = new double[n][n][n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                dp[x][y][x][y] = 1.0;
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int step = 0; step < k; step++) {
            double[][][][] newDp = new double[n][n][n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (dp[x][y][i][j] == 0.0) continue;
                            int directions = 0;
                            for (int d = 0; d < 4; d++) {
                                int ni = i + dx[d];
                                int nj = j + dy[d];
                                if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                    directions++;
                                }
                            }
                            for (int d = 0; d < 4; d++) {
                                int ni = i + dx[d];
                                int nj = j + dy[d];
                                if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                    newDp[x][y][ni][nj] += dp[x][y][i][j] / directions;
                                }
                            }
                        }
                    }
                }
            }
            dp = newDp;
        }

        double expectedEmpty = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double probEmpty = 1.0;
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        probEmpty *= (1.0 - dp[x][y][i][j]);
                    }
                }
                expectedEmpty += probEmpty;
            }
        }

        System.out.printf("%.6f\n", expectedEmpty);
    }
}