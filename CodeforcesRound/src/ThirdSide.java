import java.io.*;
import java.util.*;

public class ThirdSide {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while(t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            int[] a = new int[n];
            int totalSum =0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                totalSum +=a[i];
            }

            if (n == 1) {
                pw.println(a[0]);
                continue;
            }


                Arrays.sort(a);

                long maxValue = totalSum +  a[n - 1] + a[n - 2] - 1;
                pw.println(maxValue);
            }
            pw.flush();

    }
}
