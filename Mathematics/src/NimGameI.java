import java.io.*;
import java.util.*;

public class NimGameI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int xor =0;

            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                xor ^= x;
            }

            if (xor==0){
                System.out.println("second");
            }else{
                System.out.println("first");
            }
        }
    }
}
