import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeDistance1 {
    static final int N = 2000000; // Maximum nodes
    static List<Integer>[] adj = new ArrayList[N]; // Adjacency list
    static int[] maxd = new int[N];    // Stores the maximum depth from each node
    static int[] maxd2 = new int[N];   // Stores the second maximum depth from each node
    static int[] c = new int[N];       // Stores the child contributing to the maximum depth

    // DFS1: Calculates maxd and maxd2 for all nodes
    public static void dfs1(int v, int p) {
        maxd[v] = 0;
        maxd2[v] = 0;
        for (int x : adj[v]) {
            if (x == p) continue;
            dfs1(x, v);

            // Update maxd and maxd2
            if (maxd[x] + 1 > maxd[v]) {
                maxd2[v] = maxd[v];
                maxd[v] = maxd[x] + 1;
                c[v] = x;
            } else if (maxd[x] + 1 > maxd2[v]) {
                maxd2[v] = maxd[x] + 1;
            }
        }
    }

    // DFS2: Updates maxd and maxd2 considering the parent of each node
    public static void dfs2(int v, int p) {
        for (int x : adj[v]) {
            if (x == p) continue;

            if (c[v] == x) { // x is the child contributing to maxd[v]
                if (maxd[x] < maxd2[v] + 1) {
                    maxd2[x] = maxd[x];
                    maxd[x] = maxd2[v] + 1;
                    c[x] = v;
                } else {
                    maxd2[x] = Math.max(maxd2[x], maxd2[v] + 1);
                }
            } else {
                maxd2[x] = maxd[x];
                maxd[x] = maxd[v] + 1;
                c[x] = v;
            }
            dfs2(x, v);
        }
    }

    public static void main(String[] args) throws IOException{
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine()); // Number of nodes

        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Input edges
        for (int i = 0; i < n - 1; i++) {
            String[] edges = br.readLine().split(" ");
            int u = Integer.parseInt(edges[0]);
            int v = Integer.parseInt(edges[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        // Run DFS to calculate distances
        dfs1(1, 0);
        dfs2(1, 0);

        // Output the maximum distance for each node
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(maxd[i]).append(" ");
        }
        System.out.println(sb.toString().trim());

        
    }
}
