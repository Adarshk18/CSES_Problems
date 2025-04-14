import java.io.*;
import java.util.*;

public class Boneca {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();

        while(t-->0){
            int n = in.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            int max = 0;

            for (int k = 0; k < n; k++) {
                int curr = 0;
                for (int i = 0; i < n; i++) {
                    curr += (a[k] ^ a[i]);
                }
                max = Math.max(max,curr);
            }
            System.out.println(max);
        }
    }
}
