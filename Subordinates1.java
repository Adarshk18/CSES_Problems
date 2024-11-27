import java.io.*;
import java.util.*;

public class Subordinates1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        // Adjacency list for the tree
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        // Reading input for bosses
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            tree.get(boss).add(i);
        }

        // Array to store subordinate counts
        int[] subordinates = new int[n + 1];

        // Perform DFS iteratively
        iterativeDFS(tree, subordinates, n);

        // Build output using StringBuilder
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            result.append(subordinates[i]).append(" ");
        }
        out.println(result.toString().trim());
        out.flush();
    }

    private static void iterativeDFS(List<List<Integer>> tree, int[] subordinates, int n) {
        Stack<Integer> stack = new Stack<>();
        Stack<Boolean> processed = new Stack<>();
        stack.push(1);
        processed.push(false);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            boolean isProcessed = processed.pop();

            if (isProcessed) {
                // Post-processing step to calculate subordinates count
                int count = 0;
                for (int child : tree.get(node)) {
                    count += 1 + subordinates[child];
                }
                subordinates[node] = count;
            } else {
                // Push the current node back as processed
                stack.push(node);
                processed.push(true);

                // Push all children
                for (int child : tree.get(node)) {
                    stack.push(child);
                    processed.push(false);
                }
            }
        }
    }
}
