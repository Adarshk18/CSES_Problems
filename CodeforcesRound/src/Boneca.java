import java.io.*;
import java.util.*;

public class Boneca {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();

        while(t-->0){
            long n = in.nextLong();
            long[] a = new long[(int)n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }

            long[] fr = new long[30];
//            for (int i = 0; i < n; i++) {
//                fr[i] = in.nextLong();
//            }


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 30; j++) {
                    if ((a[i]&(1<<j))!=0){
                        fr[j]++;
                    }
                }
            }
            long ans =0;

            for (int i = 0; i < n; i++) {
                long sum =0;
                for (int j = 0; j < 30; j++) {
                    if((a[i]&(1<<j))!=0){
                        sum += (1L<<j)*(n-fr[j]);
                    }else{
                        sum += (1L<<j)*fr[j];
                    }
                }
                ans = Math.max(ans,sum);
            }
            System.out.println(ans);
        }
    }
}
