import java.io.*;
import java.util.*;

public class Brr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long t = in.nextLong();

        while(t-->0){
            long n = in.nextLong();
            long[] p = new long[(int)(2*n)];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    long a = in.nextLong();
                    p[i+j+1] = a;
                }
            }
            long total = (2*n*(2*n+1))/2;

            long acc=0;
            for (int i = 1; i < 2*n; i++) {
                acc += p[i];
            }

            p[0] = total -acc;
            for (int i = 0; i < 2*n; i++) {
                System.out.print(p[i]+ " ");
            }
            System.out.println();
        }
    }
}
