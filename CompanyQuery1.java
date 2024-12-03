import java.io.*;
import java.util.*;

public class CompanyQuery1 {
    static int[][] up; // binary lifting
    static int LOG; // moving in powers of 2
    static int[] depth; // dp[i] = max value of subtree rooted at i

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        // precompute
        LOG = (int) (Math.log(n) / Math.log(2) + 1);

        up = new int[n + 1][LOG];
        depth = new int[n + 1];

        // reading the boss hierarchy
        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            up[i][0] = boss;
        }

        process(n);

        // processing
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(get(x, k)).append("\n");
        }
        System.out.print(sb);
    }

    static void process(int n) {
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                if (up[i][j - 1] != 0) {
                    up[i][j] = up[up[i][j - 1]][j - 1];
                }
            }
        }
    }

    static int get(int x, int k) {
        for (int j = 0; j < LOG; j++) {
            if ((k & (1 << j)) > 0) {
                x = up[x][j];
                if (x == 0)
                    return -1;
            }
        }
        return x;
    }
}
