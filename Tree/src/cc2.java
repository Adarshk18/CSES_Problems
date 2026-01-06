import java.sql.Array;
import java.util.*;
import java.io.*;

public class cc2 {
    static int n,q;
    static int LOG = 18;

    static List<Integer>[] tree;
    static int[][] up;
    static int[] depth;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            tree[boss].add(i);
        }

        up = new int[n+1][LOG];
        depth = new int[n+1];

        dfs(1,0);

        while (q-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            out.println(lca(a,b));
        }
        out.flush();
    }

    static void dfs(int root, int parent) {

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(root);

        up[root][0] = parent;
        depth[root] = 0;

        while (!stack.isEmpty()) {
            int v = stack.pop();

            for (int i = 1; i < LOG; i++) {
                up[v][i] = up[ up[v][i - 1] ][i - 1];
            }

            for (int child : tree[v]) {
                depth[child] = depth[v] + 1;
                up[child][0] = v;
                stack.push(child);
            }
        }
    }


    static int lca(int a, int b){
        if (depth[a] < depth[b]){
            int temp =a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];
        for (int i = 0; i < LOG; i++) {
            if ((diff & (1<<i))!=0){
                a = up[a][i];
            }
        }

        if (a==b) return a;

        for (int i = LOG-1; i >= 0; i--) {
            if (up[a][i]!=up[b][i]){
                a = up[a][i];
                b = up[b][i];
            }
        }
        return up[a][0];
    }
}
