import java.io.*;
import java.util.*;

public class DistanceQueries {
    static final int MAXN = 200005;
    static final int LOGN = 20;

    static int N, Q;
    static int[][] p = new int[MAXN][LOGN]; // Binary lifting table
    static int[] depth = new int[MAXN];    // Depth of each node
    static int[] in = new int[MAXN];       // Entry time in DFS
    static int[] out = new int[MAXN];      // Exit time in DFS
    static int timer = 0;
    static ArrayList<Integer>[] adj = new ArrayList[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        Q = Integer.parseInt(firstLine[1]);

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            adj[a].add(b);
            adj[b].add(a);
        }

        // Preprocess LCA
        iterativeDFS(1);

        // Handle Queries
        while (Q-- > 0) {
            String[] query = br.readLine().split(" ");
            int a = Integer.parseInt(query[0]);
            int b = Integer.parseInt(query[1]);
            out.println(depth[a] + depth[b] - 2 * depth[lca(a, b)]);
        }

        out.close();
    }

    // Depth First Search to preprocess LCA using iterative method
    static void iterativeDFS(int root) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> parentStack = new Stack<>();
        stack.push(root);
        parentStack.push(root);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            int parent = parentStack.pop();

            in[node] = ++timer;
            depth[node] = depth[parent] + 1;
            p[node][0] = parent;

            for (int i = 1; i < LOGN; i++) {
                p[node][i] = p[p[node][i - 1]][i - 1];
            }

            for (int neighbor : adj[node]) {
                if (neighbor != parent) {
                    stack.push(neighbor);
                    parentStack.push(node);
                }
            }

            out[node] = ++timer;
        }
    }

    // Check if u is an ancestor of v
    static boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[u] >= out[v];
    }

    // Find Lowest Common Ancestor using binary lifting
    static int lca(int u, int v) {
        if (isAncestor(u, v)) return u;
        if (isAncestor(v, u)) return v;

        for (int i = LOGN - 1; i >= 0; i--) {
            if (!isAncestor(p[u][i], v)) {
                u = p[u][i];
            }
        }

        return p[u][0];
    }
}
