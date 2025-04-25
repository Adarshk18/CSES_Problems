import java.util.*;

public class String {
    public static int maxGCDPleasure(int[] a) {
        int n = a.length;
        int maxGCD = 1;

        // Check all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int diff = Math.abs(a[i] - a[j]);

                // Check all divisors of the difference
                for (int d = 1; d * d <= diff; d++) {
                    if (diff % d == 0) {
                        // Check both d and diff / d
                        if (isPossible(a, d)) maxGCD = Math.max(maxGCD, d);
                        if (isPossible(a, diff / d)) maxGCD = Math.max(maxGCD, diff / d);
                    }
                }
            }
        }
        return maxGCD;
    }

    // Check if there exists a remainder modulo d such that at least 2 elements give that remainder
    public static boolean isPossible(int[] a, int d) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int val : a) {
            int rem = val % d;
            count.put(rem, count.getOrDefault(rem, 0) + 1);
            if (count.get(rem) >= 2) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            System.out.println(maxGCDPleasure(a));
        }
    }
}
