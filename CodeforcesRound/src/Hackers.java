import java.io.*;
import java.util.*;

public class Hackers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            solve(in);
        }
    }

    static void solve(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.next();
        }

        String[][] b = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = in.next();
            }
        }

        int[] isPresent = new int[n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            int matches = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j].equals(b[i][j])) {
                    matches++;
                    isPresent[j] = 1;
                }
            }
            max = Math.max(max, matches);
        }

        for (int i = 0; i < n; i++) {
            if (isPresent[i] == 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(n+2 * (n - max));
    }
}
