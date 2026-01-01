import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TreeDiameter {
    static List<Integer>[] tree;
    static boolean[] visited;
    static int farthestNode = 0;
    static int maxD = 0;

    static void dfs(int node, int distance){
        visited[node] = true;

        if (distance > maxD){
            maxD = distance;
            farthestNode = node;
        }

        for(int neighbour: tree[node]){
            if (!visited[neighbour]){
                dfs(neighbour,distance+1);
            }
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        //first dfs
        visited = new boolean[n+1];
        maxD =0;
        dfs(1,0);

        //second dfs
        visited = new boolean[n+1];
        maxD = 0;
        dfs(farthestNode,0);

        System.out.println(maxD);
    }
}
