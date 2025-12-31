import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class TreeMatching {
    static int n;
    static ArrayList<Integer>[] tree;
    static long[][] dp;

    static void dfs(int u, int parent){
        long sum =0;
        for(int v: tree[u]){
            if (v==parent) continue;
            dfs(v,u);
            sum += Math.max(dp[v][0],dp[v][1]);
        }

        dp[u][0] = sum;

        long best =0;
        for(int v: tree[u]){
            if (v==parent) continue;
            long candidate = sum - Math.max(dp[v][0],dp[v][1]) + dp[v][0] + 1;
            best = Math.max(best,candidate);
        }
        dp[u][1] = best;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n+1];
        dp = new long[n+1][2];

        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1,0);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
}
