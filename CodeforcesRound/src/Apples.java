import java.util.*;

public class Apples {

    public static void solve(Scanner sc) {
        long n = sc.nextLong(); // Number of elements
        long k = sc.nextLong(); // Value of k
        long[] a = new long[(int) n]; // Array to store the elements
        long mn = Long.MAX_VALUE, mx = Long.MIN_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong(); // Read each element
            sum += a[i];
            mn = Math.min(mn, a[i]);
            mx = Math.max(mx, a[i]);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == mx) cnt++;
        }

        if (mx - mn > k + 1 || (mx - mn == k + 1 && cnt > 1)) {
            System.out.println("Jerry");
        } else {
            System.out.println(sum % 2 == 1 ? "Tom" : "Jerry");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases

        // Handle input and ensure we properly read multiple test cases
        for (int i = 0; i < t; i++) {
            solve(sc);
        }

        sc.close(); // Close the scanner after all input has been read
    }
}
