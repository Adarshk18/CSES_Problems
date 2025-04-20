import java.io.*;
import java.util.*;

public class WonderfulSticks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long t = in.nextLong();

        while (t-- > 0) {
            long n = in.nextLong();
            String s = in.next();


            long[] v = new long[(int) n];

            long l = 0, r = 0;

            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == '<') {
                    v[i + 1] = --l;
                } else {
                    v[i + 1] = ++r;
                }
            }


            for (int i = 0; i < n; i++) {
                System.out.print((v[i] - l + 1) + " ");
            }
            System.out.println();
        }
    }
}
