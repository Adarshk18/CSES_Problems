import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TreeDiameter{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //creating the adjecency list
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            ls.add(new ArrayList<>());
        }

        //reading the edges
        for (int i = 0; i < n-1; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            ls.get(a).add(b);
            ls.get(b).add(a);
        }

        int farthestNode = bfs(1, n, ls).getKey();

        int diameter = bfs(farthestNode, n, ls).getValue();

        System.out.println(diameter);
        
    }


    private static Map.Entry<Integer,Integer> bfs(int start, int n , List<List<Integer>> ls){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[n+1];

        q.add(start);
        visited[start] = true;

        int farthestNode = start;
        while(!q.isEmpty()){
            int node = q.poll();

            for(int neighbour: ls.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    distance[neighbour] = distance[node]+1;
                    q.add(neighbour);

                    //track the farthest node
                    if(distance[neighbour]>distance[farthestNode]){
                        farthestNode = neighbour;
                    }
                }
            }
        }
        return new AbstractMap.SimpleEntry<>(farthestNode,distance[farthestNode]);
    }
}