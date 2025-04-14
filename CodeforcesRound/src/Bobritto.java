import java.io.*;
import java.util.*;

public class Bobritto {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            long m = in.nextLong();
            long l = in.nextLong();
            long r = in.nextLong();

            long diff = (n-m);

            if (Math.abs(l)>=diff){
                System.out.println(l+diff + " " + r);
            }else{
                System.out.println(0 + " " + (r-l-diff));
            }
        }
    }
}
