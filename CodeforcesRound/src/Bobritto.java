import java.io.*;
import java.util.*;

public class Bobritto {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();

            int spread = n-m;

            int ls = l - spread;
            int rs = r + spread;


            System.out.println(ls + " " + rs);
        }
    }
}
