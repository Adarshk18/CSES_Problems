import java.io.*;
import java.util.*;

public class CountingPaths {
    static int[][] parent;
    static int[] level;
    static int[] value;
    static List<Integer>[] edges;
    static int limit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            edges[a].add(b);
            edges[b].add(a);
        }

        limit = (int) (Math.log(n) / Math.log(2)) + 1;
        parent = new int[n][limit];
        level = new int[n];
        value = new int[n];

        for (int[] row : parent) {
            Arrays.fill(row, -1);
        }

        // Preprocess parent and level
        dfs(0, -1);
        computeSparseTable(n);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int lca = findLCA(a, b);
            value[a]++;
            value[b]++;
            value[lca]--;
            if (parent[lca][0] != -1) {
                value[parent[lca][0]]--;
            }
        }

        propagateValues(0, -1);

        // Print the result
        for (int i = 0; i < n; i++) {
            bw.write(value[i] + " ");
        }
        bw.newLine();
        bw.flush();
    }

    // DFS to initialize parent and level
    private static void dfs(int node, int par) {
        for (int child : edges[node]) {
            if (child != par) {
                parent[child][0] = node;
                level[child] = level[node] + 1;
                dfs(child, node);
            }
        }
    }

    // Precompute sparse table for LCA
    private static void computeSparseTable(int n) {
        for (int i = 1; i < limit; i++) {
            for (int j = 0; j < n; j++) {
                if (parent[j][i - 1] != -1) {
                    parent[j][i] = parent[parent[j][i - 1]][i - 1];
                }
            }
        }
    }

    // Find LCA of two nodes
    private static int findLCA(int a, int b) {
        if (level[a] < level[b]) {
            // Swap to ensure `a` is deeper than `b`
            int temp = a;
            a = b;
            b = temp;
        }

        // Bring both nodes to the same level
        int diff = level[a] - level[b];
        for (int i = 0; i < limit; i++) {
            if ((diff & (1 << i)) != 0) {
                a = parent[a][i];
            }
        }

        if (a == b) {
            return a;
        }

        // Binary lifting to find LCA
        for (int i = limit - 1; i >= 0; i--) {
            if (parent[a][i] != -1 && parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }

    // Propagate values iteratively to avoid recursion overhead
    private static void propagateValues(int root, int par) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{root, par});

        while (!stack.isEmpty()) {
            int[] nodePair = stack.pop();
            int node = nodePair[0];
            int parent = nodePair[1];

            for (int child : edges[node]) {
                if (child != parent) {
                    stack.push(new int[]{child, node});
                }
            }

            if (parent != -1) {
                value[parent] += value[node];
            }
        }
    }
}
