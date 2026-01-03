import java.io.*;
import java.util.*;

public class TreeDistance2 {
    static int n;
    static List<Integer>[] tree;
    static long[] ans;
    static long[] dp;
    static int[] sub;

    static void dfs1(int u, int parent) {
        sub[u] = 1;
        for (int v : tree[u]) {
            if (v == parent) continue;
            dfs1(v, u);
            sub[u] += sub[v];
            dp[u] += dp[v] + sub[v];
        }
    }

    static void dfs2(int u, int parent) {
        for (int v : tree[u]) {
            if (v == parent) continue;

            ans[v] = ans[u] - sub[v] + (n - sub[v]);
            dfs2(v, u);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dp = new long[n + 1];
        ans = new long[n + 1];
        sub = new int[n + 1];

        dfs1(1, 0);
        ans[1] = dp[1];
        dfs2(1, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
