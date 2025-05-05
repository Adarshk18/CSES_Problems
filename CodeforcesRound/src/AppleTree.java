import java.util.*;

public class AppleTree {

    static class Segment implements Comparable<Segment> {
        int depth, first, second;
        List<Integer> route;

        Segment(int depth, int first, int second, List<Integer> route) {
            this.depth = depth;
            this.first = first;
            this.second = second;
            this.route = route;
        }

        @Override
        public int compareTo(Segment other) {
            if (this.depth != other.depth) return other.depth - this.depth;
            if (this.first != other.first) return other.first - this.first;
            return other.second - this.second;
        }
    }

    static List<Integer>[] graph;
    static boolean[] isActive;
    static int[] componentMarker, visitMarker, distance, distanceFromA, distanceFromB, backtrack;
    static int compLabel = 0, distLabel = 0;

    static Segment handleBranch(int base) {
        compLabel++;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> subComponent = new ArrayList<>();
        queue.add(base);
        componentMarker[base] = compLabel;
        subComponent.add(base);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (isActive[neighbor] && componentMarker[neighbor] != compLabel) {
                    componentMarker[neighbor] = compLabel;
                    queue.add(neighbor);
                    subComponent.add(neighbor);
                }
            }
        }

        distLabel++;
        int origin = subComponent.get(0);
        queue.add(origin);
        visitMarker[origin] = distLabel;
        distance[origin] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph[current]) {
                if (isActive[neighbor] && visitMarker[neighbor] != distLabel) {
                    visitMarker[neighbor] = distLabel;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        int A = origin;
        for (int node : subComponent)
            if (distance[node] > distance[A]) A = node;

        distLabel++;
        queue.add(A);
        visitMarker[A] = distLabel;
        distance[A] = 0;
        backtrack[A] = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph[current]) {
                if (isActive[neighbor] && visitMarker[neighbor] != distLabel) {
                    visitMarker[neighbor] = distLabel;
                    distance[neighbor] = distance[current] + 1;
                    backtrack[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }

        for (int node : subComponent)
            distanceFromA[node] = distance[node];

        int B = subComponent.get(0);
        for (int node : subComponent)
            if (distanceFromA[node] > distanceFromA[B]) B = node;

        int edgeLength = distanceFromA[B];

        distLabel++;
        queue.add(B);
        visitMarker[B] = distLabel;
        distance[B] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph[current]) {
                if (isActive[neighbor] && visitMarker[neighbor] != distLabel) {
                    visitMarker[neighbor] = distLabel;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        for (int node : subComponent)
            distanceFromB[node] = distance[node];

        int topNode = -1;
        for (int node : subComponent) {
            if (Math.max(distanceFromA[node], distanceFromB[node]) == edgeLength && node > topNode)
                topNode = node;
        }

        distLabel++;
        queue.add(topNode);
        visitMarker[topNode] = distLabel;
        distance[topNode] = 0;
        backtrack[topNode] = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph[current]) {
                if (isActive[neighbor] && visitMarker[neighbor] != distLabel) {
                    visitMarker[neighbor] = distLabel;
                    distance[neighbor] = distance[current] + 1;
                    backtrack[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }

        int farNode = -1;
        for (int node : subComponent) {
            if (distance[node] == edgeLength && node > farNode)
                farNode = node;
        }

        List<Integer> path = new ArrayList<>();
        for (int current = farNode; current != -1; current = backtrack[current])
            path.add(current);

        return new Segment(edgeLength + 1, topNode, farNode, path);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        while (scenarios-- > 0) {
            int nodes = scanner.nextInt();
            graph = new ArrayList[nodes + 1];
            for (int i = 0; i <= nodes; i++) graph[i] = new ArrayList<>();

            for (int i = 1; i < nodes; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

            isActive = new boolean[nodes + 1];
            Arrays.fill(isActive, true);
            componentMarker = new int[nodes + 1];
            visitMarker = new int[nodes + 1];
            distance = new int[nodes + 1];
            distanceFromA = new int[nodes + 1];
            distanceFromB = new int[nodes + 1];
            backtrack = new int[nodes + 1];

            PriorityQueue<Segment> segmentQueue = new PriorityQueue<>();
            segmentQueue.add(handleBranch(1));

            List<int[]> results = new ArrayList<>();

            while (!segmentQueue.isEmpty()) {
                Segment seg = segmentQueue.poll();
                results.add(new int[]{seg.depth, seg.first, seg.second});
                for (int x : seg.route) isActive[x] = false;
                for (int x : seg.route) {
                    for (int y : graph[x]) {
                        if (isActive[y]) {
                            segmentQueue.add(handleBranch(y));
                        }
                    }
                }
            }

            for (int[] result : results) {
                System.out.print(result[0] + " " + result[1] + " " + result[2] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
