import java.util.*;

public class MinMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int left = 0, right = n, res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(a, n, k, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }

    static boolean check(int[] a, int n, int k, int m) {
        if (m == 0) return true;

        int[] lastSeen = new int[m];
        int currentMark = 1;
        int count = 0;
        int seen = 0;

        for (int i = 0; i < n; i++) {
            int val = a[i];
            if (val < m && lastSeen[val] != currentMark) {
                lastSeen[val] = currentMark;
                seen++;
            }

            if (seen == m) {
                count++;
                currentMark++;  // virtual reset
                seen = 0;
            }
        }

        return count >= k;
    }
}
