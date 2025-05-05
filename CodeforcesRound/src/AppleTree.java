import java.util.*;

public class AppleTree {
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] removed;
    static int[] seen_id, distA, parentA, distB, distU, parentU;
    static int bfs_id;
    static List<Integer> comp_nodes;

    static class Comp {
        int d, u, v;
        List<Integer> path;

        Comp(int d, int u, int v, List<Integer> path) {
            this.d = d;
            this.u = u;
            this.v = v;
            this.path = path;
        }
    }

    static class CompareComp implements Comparator<Comp> {
        public int compare(Comp a, Comp b) {
            if (a.d != b.d) return Integer.compare(a.d, b.d);
            if (a.u != b.u) return Integer.compare(a.u, b.u);
            return Integer.compare(a.v, b.v);
        }
    }

    public static int BFS_findFarthest(int start) {
        bfs_id++;
        int id = bfs_id;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        seen_id[start] = id;
        distA[start] = 0;
        int far = start, maxd = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : adj.get(x)) {
                if (removed[y] == 0 && seen_id[y] != id) {
                    seen_id[y] = id;
                    distA[y] = distA[x] + 1;
                    q.add(y);
                    if (distA[y] > maxd) {
                        maxd = distA[y];
                        far = y;
                    }
                }
            }
        }
        return far;
    }

    public static int BFS_distParentCompNodes(int start, List<Integer> comp_nodes) {
        bfs_id++;
        int id = bfs_id;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        seen_id[start] = id;
        distA[start] = 0;
        parentA[start] = -1;
        int far = start, maxd = 0;
        comp_nodes.clear();
        comp_nodes.add(start);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : adj.get(x)) {
                if (removed[y] == 0 && seen_id[y] != id) {
                    seen_id[y] = id;
                    distA[y] = distA[x] + 1;
                    parentA[y] = x;
                    q.add(y);
                    comp_nodes.add(y);
                    if (distA[y] > maxd) {
                        maxd = distA[y];
                        far = y;
                    }
                }
            }
        }
        return far;
    }

    public static void BFS_distOnly(int start) {
        bfs_id++;
        int id = bfs_id;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        seen_id[start] = id;
        distB[start] = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : adj.get(x)) {
                if (removed[y] == 0 && seen_id[y] != id) {
                    seen_id[y] = id;
                    distB[y] = distB[x] + 1;
                    q.add(y);
                }
            }
        }
    }

    public static int BFS_distParentLexFarthest(int start) {
        bfs_id++;
        int id = bfs_id;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        seen_id[start] = id;
        distU[start] = 0;
        parentU[start] = -1;
        int far = start, maxd = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : adj.get(x)) {
                if (removed[y] == 0 && seen_id[y] != id) {
                    seen_id[y] = id;
                    distU[y] = distU[x] + 1;
                    parentU[y] = x;
                    q.add(y);
                    if (distU[y] > maxd || (distU[y] == maxd && y > far)) {
                        maxd = distU[y];
                        far = y;
                    }
                }
            }
        }
        return far;
    }

    public static Comp get_comp(int start) {
        int A1 = BFS_findFarthest(start);
        int B1 = BFS_distParentCompNodes(A1, comp_nodes);
        BFS_distOnly(B1);
        int D = distA[B1];
        int u_max = 0;
        for (int u : comp_nodes) {
            if (distA[u] == D || distB[u] == D) {
                if (u > u_max) u_max = u;
            }
        }
        int v_max = BFS_distParentLexFarthest(u_max);
        List<Integer> P = new ArrayList<>();
        int x = v_max;
        while (x != -1) {
            P.add(x);
            x = parentU[x];
        }
        return new Comp(P.size(), u_max, v_max, P);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            // Initialize data structures for each test case
            int n = sc.nextInt();
            adj.clear();
            removed = new int[n + 1];
            seen_id = new int[n + 1];
            distA = new int[n + 1];
            parentA = new int[n + 1];
            distB = new int[n + 1];
            distU = new int[n + 1];
            parentU = new int[n + 1];
            comp_nodes = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 1; i < n; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            // Call get_comp() or any other function you want to execute
            Comp c0 = get_comp(1);
            System.out.println(c0.d + " " + c0.u + " " + c0.v);
        }
    }
}
