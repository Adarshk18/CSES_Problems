import java.util.*;

class MedianSplits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            boolean hasK = false;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] == k) hasK = true;
            }

            // If no element is equal to k, then we can't form such a split
            if (!hasK) {
                System.out.println("NO");
                continue;
            }

            // For n == 3, we just check directly
            if (n == 3) {
                int[] temp = Arrays.copyOf(a, n);
                Arrays.sort(temp);
                int median = temp[1];
                System.out.println(median <= k ? "YES" : "NO");
                continue;
            }

            boolean possible = false;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] <= k && a[i + 1] <= k) {
                    possible = true;
                    break;
                }
                if (i + 2 < n && a[i] <= k && a[i + 2] <= k) {
                    possible = true;
                    break;
                }
            }

            System.out.println(possible ? "YES" : "NO");
        }
    }
}
