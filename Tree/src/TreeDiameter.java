import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TreeDiameter {
    static List<Integer>[] tree;

    static int bfs(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n + 1];

        q.add(start);
        visited[start] = true;

        int farthest = start;

        while (!q.isEmpty()) {
            int node = q.poll();

            farthest = node;
            for (int nei : tree[node]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    dist[nei] = dist[node] + 1;
                    q.add(nei);
                }
            }
        }
        return farthest;
    }

    static int bfsDist(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n + 1];

        q.add(start);
        visited[start] = true;

        int maxD = 0;
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei : tree[node]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    dist[nei] = dist[node] + 1;
                    maxD = Math.max(maxD, dist[nei]);
                    q.add(nei);
                }
            }
        }
        return maxD;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        int aa = bfs(1, n);
        int da = bfsDist(aa, n);

        System.out.println(da);
    }
}
