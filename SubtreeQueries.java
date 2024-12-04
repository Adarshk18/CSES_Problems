import java.io.*;
import java.util.*;

public class SubtreeQueries {
    static int[] values, euler, subtreeSize, parent, depth, segmentTree;
    static int n, q;
    static List<List<Integer>> adj;
    static int timer = 0;

    static void dfs(int node, int par) {
        euler[node] = timer++;
        subtreeSize[node] = 1;
        parent[node] = par;
        update(euler[node], values[node]); // Initialize the segment tree with node values

        for (int neighbor : adj.get(node)) {
            if (neighbor != par) {
                depth[neighbor] = depth[node] + 1;
                dfs(neighbor, node);
                subtreeSize[node] += subtreeSize[neighbor];
            }
        }
    }

    static void update(int index, int value) {
        index += n;
        segmentTree[index] = value;
        for (index /= 2; index > 0; index /= 2) {
            segmentTree[index] = segmentTree[2 * index] + segmentTree[2 * index + 1];
        }
    }

    static long query(int left, int right) {
        left += n;
        right += n + 1;
        long sum = 0;
        while (left < right) {
            if ((left & 1) == 1) sum += segmentTree[left++];
            if ((right & 1) == 1) sum += segmentTree[--right];
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        values = new int[n + 1];
        euler = new int[n + 1];
        subtreeSize = new int[n + 1];
        parent = new int[n + 1];
        depth = new int[n + 1];
        segmentTree = new int[2 * n];

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        dfs(1, -1);

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int s = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                values[s] = x;
                update(euler[s], x);
            } else {
                int a = Integer.parseInt(st.nextToken());
                long result = query(euler[a], euler[a] + subtreeSize[a] - 1);
                sb.append(result).append("\n");
            }
        }
        System.out.print(sb);
    }
}
