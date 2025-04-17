import java.io.*;
import java.util.*;

public class Trulimero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while(t-->0){
            long n = in.nextLong();
            long m = in.nextLong();
            long k = in.nextLong();

            if (m%k==0){
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(1+(j+i)%k + " ");
                    }
                    System.out.println();
                }
            }else{
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(1+(m*i+j)%k + " ");
                    }
                    System.out.println();
                }
            }
        }
        in.close();
    }
}
