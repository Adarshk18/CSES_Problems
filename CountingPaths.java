import java.util.*;

public class CountingPaths {
    static final int MAXN = 200000;
    static final int LOG = 18;  // Maximum depth of binary lifting (log2(200000) ≈ 17)

    static int[] parent = new int[MAXN + 1], depth = new int[MAXN + 1], count = new int[MAXN + 1];
    static int[][] up = new int[MAXN + 1][LOG];
    static List<Integer>[] tree = new ArrayList[MAXN + 1];

    // Binary Lifting: Precompute ancestors for each node
    public static void dfs(int node, int par) {
        parent[node] = par;
        for (int child : tree[node]) {
            if (child != par) {
                depth[child] = depth[node] + 1;
                up[child][0] = node; // Direct parent
                for (int i = 1; i < LOG; i++) {
                    if (up[child][i - 1] != -1) {
                        up[child][i] = up[up[child][i - 1]][i - 1];
                    }
                }
                dfs(child, node);
            }
        }
    }

    // Find LCA using binary lifting
    public static int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        // Bring u and v to the same level
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = up[u][i];
            }
        }
        if (u == v) return u;
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }
        return parent[u];
    }

    // Mark the path from a to b
    public static void markPath(int a, int b) {
        int commonAncestor = lca(a, b);
        // Move up from a to LCA
        while (a != commonAncestor) {
            count[a]++;
            a = parent[a];
        }
        // Move up from b to LCA
        while (b != commonAncestor) {
            count[b]++;
            b = parent[b];
        }
        // Include the LCA node itself
        count[commonAncestor]++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read number of nodes and paths
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Initialize tree and parent tracking
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // Read the tree edges
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }

        // Perform DFS to initialize parent and depth arrays and binary lifting
        depth[1] = 0;  // Root the tree at node 1
        Arrays.fill(up, -1);
        dfs(1, -1);

        // Read the paths and mark nodes on the path
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            markPath(a, b);
        }

        // Output the count for each node
        for (int i = 1; i <= n; i++) {
            System.out.print(count[i] + " ");
        }
    }
}
