import java.io.*;
import java.util.*;

public class Spiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long y = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            long layer = Math.max(y, x);
            long start = (layer - 1) * (layer - 1) + 1;

            if (layer % 2 == 0) {
                if (x >= y) {
                    pw.println(start + y - 1);
                } else {
                    pw.println(start + 2 * (layer - 1) - (x - 1));
                }
            } else {
                if (y >= x) {
                    pw.println(start + x - 1);
                } else {
                    pw.println(start + 2 * (layer - 1) - (y - 1));
                }
            }
        }

        pw.flush();
    }
}