import java.io.*;
import java.util.*;

public class CountingPaths {
    static List<Integer>[] tree;
    static int[] pathCnt;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        
        tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
           tree[i] = new ArrayList<>(); 
        }

        for (int i = 0; i < n-1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }
        
        pathCnt = new int[n+1];

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            List<Integer> path = findPath(a,b,n);
            for(int node: path){
                pathCnt[node]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(pathCnt[i]);
            if (i<n) System.out.print(" ");
        }
        System.out.println();
    }

    static List<Integer> findPath(int start, int end, int n){
        boolean[] vis = new boolean[n+1];
        List<Integer> path = new ArrayList<>();
        dfs(start, end, vis, path);
        return path;
    }

    static boolean dfs(int curr, int target, boolean[] vis, List<Integer> path){
        vis[curr] = true;
        path.add(curr);

        if (curr == target){
            return true;
        }

        for(int nei: tree[curr]){
            if (!vis[nei]){
                if (dfs(nei,target,vis,path)){
                    return true;
                }
            }
        }
        path.remove(path.size()-1);
        return false;
    }
}
