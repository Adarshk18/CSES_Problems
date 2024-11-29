import java.util.*;

public class TreeDistance {

    static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // BFS function to find the farthest node and its distance
    public static Pair bfs(int startNode, int n, List<List<Integer>> adj) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startNode, 0));

        boolean[] visited = new boolean[n + 1];
        visited[startNode] = true;

        Pair farthest = new Pair(0, 0);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            farthest = current;

            for (int neighbor : adj.get(current.node)) {
                if (!visited[neighbor]) {
                    queue.add(new Pair(neighbor, current.distance + 1));
                    visited[neighbor] = true;
                }
            }
        }

        return farthest;
    }

    // DFS function to calculate the distances from the given node
    public static void dfs(int parent, int node, int distance, int index, List<List<Integer>> adj, int[][] dp) {
        dp[node][index] = distance;

        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                dfs(node, neighbor, distance + 1, index, adj, dp);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // First BFS to find one endpoint of the tree diameter
        Pair p = bfs(1, n, adj);

        // Second BFS to find the other endpoint of the tree diameter
        Pair pp = bfs(p.node, n, adj);

        int[][] dp = new int[n + 1][2];

        // Calculate distances from the two endpoints
        dfs(0, p.node, 0, 0, adj, dp);
        dfs(0, pp.node, 0, 1, adj, dp);

        // Print the result for each node
        for (int i = 1; i <= n; i++) {
            System.out.print(Math.max(dp[i][0], dp[i][1]) + " ");
        }
    }
}
