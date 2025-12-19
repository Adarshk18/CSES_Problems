import java.util.*;

public class MinimalGridPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }

        boolean[][] curr = new boolean[n][n];
        boolean[][] next = new boolean[n][n];

        StringBuilder sb = new StringBuilder();

        curr[0][0] = true;
        sb.append(grid[0][0]);

        for (int step = 0; step < 2 * n - 2; step++) {
            char best = 'Z';

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!curr[i][j]) continue;

                    if (i + 1 < n) {
                        best = (char) Math.min(best, grid[i + 1][j]);
                    }

                    if (j + 1 < n) {
                        best = (char) Math.min(best, grid[i][j + 1]);
                    }


                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!curr[i][j]) continue;

                    if (i + 1 < n && grid[i + 1][j] == best) {
                        next[i + 1][j] = true;
                    }

                    if (j + 1 < n && grid[i][j + 1] == best) {
                        next[i][j + 1] = true;
                    }
                }
            }
            sb.append(best);
            boolean[][] temp = curr;
            curr = next;
            next = temp;

            for (int i = 0; i < n; i++) {
                Arrays.fill(next[i], false);
            }
        }
        System.out.println(sb.toString());
    }
}
