import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class TreeDiameter1 {
    public static void main(String[] args) throws Exception{
        FastReader br = new FastReader();
        int n = br.nextInt();

        if(n==1){
            System.out.println(0);
            return;
        }

        //creating adjecency list
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            ls.add(new ArrayList<>());
        }

        //reading the edges
        for (int i = 0; i < n-1; i++) {
           
            int a = br.nextInt();
            int b = br.nextInt();
            ls.get(a).add(b);
            ls.get(b).add(a);
        }

        int[] bfsA = bfs(1, n, ls);
        int A = bfsA[0];

        int[] bfsB = bfs(A,n,ls);
        int B = bfsB[0];

        int[] bfsC = bfs(B,n,ls);

        // int[] masDistance = new int[n+1];
        // for (int i = 1; i <= n; i++) {
        //     masDistance[i] = Math.max(bfsB[i], bfsC[i]);
        // }


        StringBuilder brr = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            brr.append(Math.max(bfsB[i],bfsC[i])).append(" ");
        }
        System.out.println(brr.toString().trim());

    }

    private static int[] bfs(int start, int n, List<List<Integer>> ls){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];

        q.add(start);
        visited[start] = true;

        int farthest = start;

        while(!q.isEmpty()){
            int node = q.poll();   
            
            for (int neighbor: ls.get(node)) {
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node]+1;
                    q.add(neighbor);


                    if(distance[neighbor]>distance[farthest]){
                        farthest = neighbor;
                    }
                }
            }
        }
        distance[0] = farthest;
        return distance;
    }

     static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
