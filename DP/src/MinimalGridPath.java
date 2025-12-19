import java.io.*;
import java.util.*;

public class MinimalGridPath {

    static class Cell {
        int i, j;
        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        StringBuilder ans = new StringBuilder();
        ans.append(grid[0][0]);

        List<Cell> curr = new ArrayList<>();
        curr.add(new Cell(0, 0));

        for (int step = 0; step < 2 * n - 2; step++) {

            char best = 'Z';


            for (Cell c : curr) {
                int i = c.i, j = c.j;
                if (i + 1 < n) best = (char) Math.min(best, grid[i + 1][j]);
                if (j + 1 < n) best = (char) Math.min(best, grid[i][j + 1]);
            }


            List<Cell> next = new ArrayList<>();
            boolean[][] used = new boolean[n][n];

            for (Cell c : curr) {
                int i = c.i, j = c.j;

                if (i + 1 < n && grid[i + 1][j] == best && !used[i + 1][j]) {
                    used[i + 1][j] = true;
                    next.add(new Cell(i + 1, j));
                }

                if (j + 1 < n && grid[i][j + 1] == best && !used[i][j + 1]) {
                    used[i][j + 1] = true;
                    next.add(new Cell(i, j + 1));
                }
            }

            ans.append(best);
            curr = next;
        }

        System.out.println(ans.toString());
    }
}
