import java.io.*;
import java.util.*;

public class FizzBuzz {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            long n = Long.parseLong(br.readLine());

            long count = (n / 15) * 3;
            if (n % 15 >= 0) count++;
            if (n % 15 >= 1) count++;
            if (n % 15 >= 2) count++;
            pw.println(count);
        }
        pw.flush();
    }
}
