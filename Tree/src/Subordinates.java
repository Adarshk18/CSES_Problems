import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Subordinates {
    static List<Integer>[] tree;
    static int[] subordinates;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n+1];
        subordinates = new int[n+1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            tree[boss].add(i);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subordinates[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static void dfs(int node){
        for(int child: tree[node]){
            dfs(child);
            subordinates[node] += subordinates[child] + 1;
        }
    }
}
