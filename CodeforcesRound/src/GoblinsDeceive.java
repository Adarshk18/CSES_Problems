import java.io.*;

public class GoblinsDeceive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // Length of the string
            String s = br.readLine(); // The string itself

            // Count occurrences of '-' and '_'
            int countDash = 0, countUnderscore = 0;
            for (char c : s.toCharArray()) {
                if (c == '-') countDash++;
                else countUnderscore++;
            }

            // If we cannot form "-_-", return 0
            if (countDash < 2 || countUnderscore < 1 || n < 3) {
                pw.println(0);
                continue;
            }

            // Correct formula to maximize "-_-"
            long maxSubsequences = (long) (countDash - 1) * Math.min(countUnderscore, countDash - 1);
            pw.println(maxSubsequences);
        }

        pw.flush();
    }
}
