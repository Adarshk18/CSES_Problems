import java.io.*;
import java.util.*;

public class LimitedRepainting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            // Binary search for the minimum maximum penalty
            int left = 0, right = Arrays.stream(a).max().getAsInt();
            int result = right;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (canAchievePenalty(n, k, s, a, mid)) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            pw.println(result);
        }

        pw.flush();
    }

    private static boolean canAchievePenalty(int n, int k, String s, int[] a, int maxPenalty) {
        int operations = 0;
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == 'B' && a[i] > maxPenalty) {
                // Need to paint this cell blue
                operations++;
                i++;
            } else if (s.charAt(i) == 'R' && a[i] > maxPenalty) {
                // Need to ensure this cell remains red
                // Skip until the next cell that needs to be blue
                while (i < n && (s.charAt(i) == 'R' || a[i] <= maxPenalty)) {
                    i++;
                }
            } else {
                i++;
            }

            if (operations > k) {
                return false;
            }
        }

        return operations <= k;
    }
}