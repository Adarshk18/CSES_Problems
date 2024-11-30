import java.util.*;

public class TreeDistance2 {
    static final int MAX_NODES = 200001;
    static List<Integer>[] tree = new ArrayList[MAX_NODES];
    static long[] subtreeAns = new long[MAX_NODES];   // Sum of distances in the subtree
    static long[] ans = new long[MAX_NODES];         // Final answer for each node
    static int[] subtreeSize = new int[MAX_NODES];   // Size of each subtree

    // Preprocessing: Calculates subtree sizes and subtree distances
    public static void preprocessing(int src, int par) {
        int numOfNodes = 1;
        long ansForSubtree = 0;

        for (int child : tree[src]) {
            if (child != par) {
                preprocessing(child, src);
                numOfNodes += subtreeSize[child];
                ansForSubtree += subtreeSize[child] + subtreeAns[child];
            }
        }

        subtreeSize[src] = numOfNodes;
        subtreeAns[src] = ansForSubtree;
    }

    // Solve: Calculates the answer for each node using parent's information
    public static void solve(int src, int par, long parAns, int totalNodes) {
        ans[src] = subtreeAns[src] + (parAns + (totalNodes - subtreeSize[src]));

        for (int child : tree[src]) {
            if (child != par) {
                long newParAns = ans[src] - (subtreeAns[child] + subtreeSize[child]);
                solve(child, src, newParAns, totalNodes);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of nodes
        int n = sc.nextInt();

        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // Read edges
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        // Preprocess subtree sizes and distances
        preprocessing(1, 0);

        // Solve for all nodes
        solve(1, 0, 0, n);

        // Output results
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString().trim());

        sc.close();
    }
}
