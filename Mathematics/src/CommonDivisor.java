import java.io.*;
import java.util.*;

public class CommonDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int[] freq = new int[1000001]; // Since xi ≤ 10^6

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            freq[num]++;
        }

        // Iterate from largest number down to 1
        for (int g = 1000000; g >= 1; g--) {
            int count = 0;
            for (int multiple = g; multiple <= 1000000; multiple += g) {
                count += freq[multiple];
                if (count >= 2) { // We found at least two numbers with gcd = g
                    pw.println(g);
                    pw.flush();
                    return;
                }
            }
        }
    }
}
