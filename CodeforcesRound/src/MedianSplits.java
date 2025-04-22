import java.util.*;

public class MedianSplits {
    static int find(int[] a, int n, int k, int start, int diff) {
        int cnt = 0;
        int i = start;
        while (i >= 0 && i < n) {
            if (a[i] <= k) cnt++;
            else cnt--;
            if (cnt >= 0) return i;
            i += diff;
        }
        return diff == 1 ? n : -1;
    }

    static boolean first2(int[] a, int n, int k) {
        int l = find(a, n, k, 0, 1);
        if (l % 2 == 0 && l + 1 < n && a[l + 1] > k) l++;
        int r = find(a, n, k, l + 1, 1);
        return r < n - 1;
    }

    static boolean last2(int[] a, int n, int k) {
        int r = find(a, n, k, n - 1, -1);
        if ((n - r) % 2 == 1 && r - 1 >= 0 && a[r - 1] > k) r--;
        int l = find(a, n, k, r - 1, -1);
        return l > 0;
    }

    static boolean outer2(int[] a, int n, int k) {
        int l = find(a, n, k, 0, 1);
        int r = find(a, n, k, n - 1, -1);
        return r - l > 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            boolean result = first2(a, n, k) || last2(a, n, k) || outer2(a, n, k);
            System.out.println(result ? "YES" : "NO");
        }

        sc.close();
    }
}
