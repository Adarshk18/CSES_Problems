import java.io.*;
import java.util.*;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String line = br.readLine();
            if (line == null) {
                break; // Exit if there is no more input
            }
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // Check if the total coins are divisible by 3 and the maximum value is not greater than twice the minimum value
            if ((a + b) % 3 == 0 && Math.max(a, b) <= 2 * Math.min(a, b)) {
                pw.println("YES");
            } else {
                pw.println("NO"); // Use println instead of print
            }
        }

        pw.flush();
        pw.close();
    }
}