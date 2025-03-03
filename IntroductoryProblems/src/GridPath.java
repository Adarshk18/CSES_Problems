import java.util.*;

public class GridPath {
    static int totalPaths = 0;
    static boolean[][] visited = new boolean[7][7];
    static String path;

    static int[] dx = {1, -1, 0, 0}; // D, U, L, R
    static int[] dy = {0, 0, -1, 1};
    static char[] dir = {'D', 'U', 'L', 'R'};

    public static void dfs(int x, int y, int step) {
        // If we reached (6,0) exactly at step 48, count this as a valid path
        if (x == 6 && y == 0) {
            if (step == 48) totalPaths++;
            return;
        }
        // If path is complete but didn't reach (6,0), return
        if (step == 48) return;

        // Pruning: If the path is already surrounded on three sides, stop early
        if (isDeadEnd(x, y)) return;

        visited[x][y] = true;

        // Try moving in all four directions
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // If given path has a specific direction, and it's not this one, skip it
            if (path.charAt(step) != '?' && path.charAt(step) != dir[i]) continue;

            // Move if it's within bounds and not visited
            if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && !visited[nx][ny]) {
                dfs(nx, ny, step + 1);
            }
        }

        visited[x][y] = false; // Backtrack
    }

    // Pruning function to detect dead ends
    public static boolean isDeadEnd(int x, int y) {
        int blocked = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || nx >= 7 || ny < 0 || ny >= 7 || visited[nx][ny]) {
                blocked++;
            }
        }
        return blocked >= 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        path = sc.next();
        sc.close();

        dfs(0, 0, 0);
        System.out.println(totalPaths);
    }
}
