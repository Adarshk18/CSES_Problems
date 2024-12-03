import java.io.*;
import java.util.*;

public class CompanyQuery2 {
    static int n, q;
    static List<Integer>[] tree; // Tree structure
    static int[][] ancestor; // Binary lifting table
    static int[] depth; // Depth of each node

    // Pre-process to compute the ancestor table for binary lifting
    static void preProcess(int root, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        depth[root] = 1;
        ancestor[root][0] = -1;
    
        while (!queue.isEmpty()) {
            int node = queue.poll();
    
            for (int child : tree[node]) {
                if (depth[child] == 0) { // Unvisited
                    depth[child] = depth[node] + 1;
                    ancestor[child][0] = node;
                    queue.add(child);
    
                    // Compute binary lifting table
                    for (int i = 1; i <= 20; i++) {
                        if (ancestor[child][i - 1] != -1) {
                            ancestor[child][i] = ancestor[ancestor[child][i - 1]][i - 1];
                        } else {
                            ancestor[child][i] = -1;
                        }
                    }
                }
            }
        }
    }
    

    // DFS to calculate depth of each node
    static void dfs(int node, int d) {
        depth[node] = d;
        for (int child : tree[node]) {
            if (depth[child] == 0) { // Avoid revisiting
                dfs(child, d + 1);
            }
        }
    }

    // Function to find the Lowest Common Ancestor (LCA)
    static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            // Swap to ensure `b` is deeper
            int temp = a;
            a = b;
            b = temp;
        }

        // Lift `b` to the same level as `a`
        int diff = depth[b] - depth[a];
        for (int i = 0; i < 20; i++) {
            if ((diff & (1 << i)) != 0) {
                b = ancestor[b][i];
            }
        }

        if (a == b) return a;

        // Binary lifting to find the LCA
        for (int i = 20; i >= 0; i--) {
            if (ancestor[a][i] != ancestor[b][i]) {
                a = ancestor[a][i];
                b = ancestor[b][i];
            }
        }

        return ancestor[a][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
    
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
    
        ancestor = new int[n + 1][21];
        depth = new int[n + 1];
    
        // Read parent-child relationships in a single line
        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            tree[parent].add(i);
        }
    
        // Pre-processing
        preProcess(1, -1);
        dfs(1, 1);
    
        // Process queries
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pw.println(lca(a, b));
        }
    
        pw.flush();
    }
    
}
