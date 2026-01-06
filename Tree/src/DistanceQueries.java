import java.util.*;
import java.io.*;

public class DistanceQueries {
    static int n,q;
    static List<Integer>[] tree;
    static int[][] parent;
    static int[] depth;
    static int LOG = 20;

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

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        parent = new int[n+1][LOG];
        depth = new int[n+1];

        dfs(1,0);

        for(int j=1; j< LOG; j++){
            for(int i=1; i<=n; i++){
                parent[i][j] = parent[parent[i][j-1]][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lca = lca(a,b);
            int dist = depth[a] + depth[b] - 2*depth[lca];
            sb.append(dist).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int node, int par){
        parent[node][0] = par;
        for(int next: tree[node]){
            if(next!=par){
                depth[next] = depth[node]+1;
                dfs(next, node);
            }
        }
    }
    static int lca(int a, int b){
        if (depth[a]<=depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }

        for(int i=LOG-1; i>=0; i--){
            if (depth[a] - (1<<i) >= depth[b]){
                a= parent[a][i];
            }
        }

        if (a==b) return a;

        for(int i=LOG-1; i>=0; i--){
            if (parent[a]!=parent[b]){
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }
}
