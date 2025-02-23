import java.io.*;
import java.util.*;

public class Permutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            pw.println(1);
        } else if (n == 2 || n == 3) {
            pw.println("NO SOLUTION");
        } else {
            // Print even numbers in ascending order
            for (int i = 2; i <= n; i += 2) {
                pw.print(i + " ");
            }
            // Print odd numbers in ascending order
            for (int i = 1; i <= n; i += 2) {
                pw.print(i + " ");
            }
        }
        pw.flush();
    }
}