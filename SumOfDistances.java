// import java.io.*;
// import java.util.*;

// public class SumOfDistances{
//     static int[] subtreeSizes,distanceSum;
//     static List<List<Integer>> tree;
//     static int n;
    
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         n = Integer.parseInt(br.readLine());

//         tree = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             tree.add(new ArrayList<>());
//         }

//         //reading the edges
//         for (int i = 0; i < n-1; i++) {
//             String[] edges = br.readLine().split(" ");
//             int a = Integer.parseInt(edges[0]);
//             int b = Integer.parseInt(edges[1]);
//             tree.get(a).add(b);
//             tree.get(b).add(a);
//         }

//         subtreeSizes = new int[n+1];
//         distanceSum = new int[n+1];

//         dfs1(1,-1);
//         dfs2(1,-1);

//         StringBuilder result = new StringBuilder();
//         for(int i=1; i<=n; i++){
//             result.append(distanceSum[i]).append(" ");

//         }
//         System.out.println(result.toString().trim());

//     }

//     private static void dfs1(int nodes, int parent){
//         subtreeSizes[nodes] = 1;
//         for(int neighbor: tree.get(nodes)){
//             if(neighbor!=parent){
//                 dfs1(neighbor,nodes);
//                 subtreeSizes[nodes] += subtreeSizes[neighbor];
//                 distanceSum[nodes] += distanceSum[neighbor] + subtreeSizes[neighbor];
//             }
//         }
//     }

//     private static void dfs2(int nodes, int parent){
//         for(int neighbor: tree.get(nodes)){
//             if(neighbor!=nodes){
//                 distanceSum[neighbor] = distanceSum[nodes] + (n-2*subtreeSizes[neighbor]);
//                 dfs2(neighbor,nodes);
//             }
//         }
//     }
// }

import java.io.*;
import java.util.*;

public class SumOfDistances {
    static long[] subtreeSize, distanceSum;
    static List<List<Integer>> tree;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
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

        subtreeSize = new long[n + 1];
        distanceSum = new long[n + 1];

        // First DFS: Calculate distanceSum[1] and subtree sizes
        dfs1(1, -1);

        // Second DFS: Calculate distances for all nodes
        dfs2(1, -1);

        // Output the result
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            result.append(distanceSum[i]).append(" ");
        }
        System.out.println(result.toString().trim());
    }

    // First DFS: Calculate distanceSum for the root and subtree sizes
    private static void dfs1(int node, int parent) {
        subtreeSize[node] = 1; // Count the current node
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                dfs1(neighbor, node);
                subtreeSize[node] += subtreeSize[neighbor];
                distanceSum[node] += distanceSum[neighbor] + subtreeSize[neighbor];
            }
        }
    }

    // Second DFS: Calculate distanceSum for all nodes
    private static void dfs2(int node, int parent) {
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                // Calculate distance for the child based on the parent's distance
                distanceSum[neighbor] = distanceSum[node] + (n - 2 * subtreeSize[neighbor]);
                dfs2(neighbor, node);
            }
        }
    }
}
