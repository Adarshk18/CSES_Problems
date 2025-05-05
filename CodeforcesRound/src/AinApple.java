import java.util.*;

public class AinApple {

    static class Pair {
        int x, y;
        Pair(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            process(scanner);
        }
    }

    private static void process(Scanner scanner) {
        int totalNodes = scanner.nextInt();
        long desiredTriangles = scanner.nextLong();
        long maxTriangles = (long) totalNodes * (totalNodes - 1) * (totalNodes - 2) / 6;

        if (desiredTriangles > maxTriangles + 1) {
            System.out.println("No");
            return;
        }

        long remaining = desiredTriangles;
        List<Integer> coreStructure = new ArrayList<>();

        for (int i = totalNodes - 1; i >= 2; --i) {
            long possibleTriangles = (long) i * (i - 1) / 2;
            if (possibleTriangles <= remaining) {
                coreStructure.add(i);
                remaining -= possibleTriangles;
            }
        }

        int baseLength = coreStructure.size();
        int nodesInBase = baseLength + 1;
        long[] leafCount = new long[nodesInBase + 3];
        long[] suffixSum = new long[nodesInBase + 4];

        if (baseLength == 0) {
            leafCount[1] = totalNodes - 1;
        } else {
            int first = coreStructure.get(0);
            leafCount[1] = totalNodes - 1 - first;
            for (int i = 2; i <= nodesInBase; ++i) {
                int prev = coreStructure.get(i - 2);
                suffixSum[i] = prev - (nodesInBase - (i - 1));
            }
            suffixSum[nodesInBase + 1] = 0;
            for (int i = 2; i <= nodesInBase; ++i) {
                leafCount[i] = suffixSum[i] - suffixSum[i + 1];
            }
        }

        System.out.println("Yes");
        List<Pair> treeEdges = new ArrayList<>();
        for (int i = 2; i <= nodesInBase; ++i) {
            treeEdges.add(new Pair(i - 1, i));
        }

        int labelCounter = nodesInBase + 1;
        for (int i = 1; i <= nodesInBase; ++i) {
            for (int j = 0; j < leafCount[i]; ++j) {
                treeEdges.add(new Pair(i, labelCounter++));
            }
        }

        for (Pair edge : treeEdges) {
            System.out.println(edge.x + " " + edge.y);
        }
    }

    public static void main(String[] args) {
        execute();
    }
}
