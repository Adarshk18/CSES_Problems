import java.io.*;
import java.util.*;

public class TwoKing {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        for (int k = 1; k <= n; k++) {
            long totalWays = (long) k*k*(k*k-1)/2;
            long attackingWys = 4 * (k-1)*(k-2);
            long validWays = totalWays - attackingWys;
            pw.println(validWays);
        }
        pw.flush();
    }
}
