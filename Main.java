import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[][] dp;

    // Function to solve the problem recursively
    public static void solve(int src, int par) {
        ArrayList<Integer> prefix = new ArrayList<>();
        ArrayList<Integer> suffix = new ArrayList<>();
        dp[src][0] = dp[src][1] = 0;

        boolean leaf = true;
        for (int child : tree[src]) {
            if (child != par) {
                leaf = false;
                solve(child, src);
            }
        }

        if (leaf) return;

        for (int child : tree[src]) {
            if (child != par) {
                int maxChild = Math.max(dp[child][0], dp[child][1]);
                prefix.add(maxChild);
                suffix.add(maxChild);
            }
        }

        // Compute prefix sums
        for (int i = 1; i < prefix.size(); i++) {
            prefix.set(i, prefix.get(i) + prefix.get(i - 1));
        }

        // Compute suffix sums
        for (int i = suffix.size() - 2; i >= 0; i--) {
            suffix.set(i, suffix.get(i) + suffix.get(i + 1));
        }

        dp[src][0] = suffix.get(0);
        int c_no = 0;

        for (int child : tree[src]) {
            if (child == par) continue;

            int leftChildren = (c_no == 0) ? 0 : prefix.get(c_no - 1);
            int rightChildren = (c_no == suffix.size() - 1) ? 0 : suffix.get(c_no + 1);

            dp[src][1] = Math.max(dp[src][1], 1 + leftChildren + rightChildren + dp[child][0]);
            c_no++;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        tree = new ArrayList[n + 1];
        dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 2; i <= n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        solve(1, 0);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    // Helper class for fast input
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
