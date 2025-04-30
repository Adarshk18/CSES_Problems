import java.io.*;
import java.lang.String;
import java.util.*;

public class StringMatching {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        String p = in.next();

        int n = s.length();
        int m = p.length();


            int occurances = 0;
            for (int i = 0; i <= n-m; i++) {
                if (s.substring(i,i+m).equals(p)){
                    occurances++;
                }

            }
            System.out.println(occurances);


    }
}
