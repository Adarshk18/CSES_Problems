import java.io.*;
import java.util.*;

public class Move {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-->0){
            int n = in.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            long[] pref = new long[n];

            pref[0] = a[0];
            for (int i = 1; i < n; i++) {
                pref[i] = Math.max(pref[i-1], a[i]);
            }
            long sum =0;
            for (int i = n-1; i >= 0; i--) {
                System.out.print(sum + pref[i] + " ");
                sum += a[i];
            }
            System.out.println();
        }
    }
}
