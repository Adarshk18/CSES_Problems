import java.io.*;
import java.util.*;

public class MaximumMatchingInTree {
    public static void main(String[] args) throws IOException {
        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Edge case: A single node tree
        if (n == 1) {
            System.out.println(0);
            return;
        }

        // Create adjacency list
        List<List<Integer>> tree = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < n - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // Visited array to keep track of matched nodes
        boolean[] visited = new boolean[n + 1];
        int matchingCount = 0;

        // Iterative DFS
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // Start from node 1
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            // Traverse all neighbors
            for (int neighbor : tree.get(node)) {
                if (neighbor != parent[node]) { // Avoid revisiting the parent
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                        parent[neighbor] = node;
                    }
                }
            }

            // Attempt to match the node with its parent (if possible)
            if (parent[node] != -1 && !visited[node] && !visited[parent[node]]) {
                matchingCount++;
                visited[node] = true;
                visited[parent[node]] = true;
            }
        }

        // Output the maximum matching count
        System.out.println(matchingCount);
    }
}
