import java.io.*;
import java.util.*;

public class TrailingZeros {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int  n = Integer.parseInt(br.readLine());

        pw.println(zeros(n));
        pw.flush();
    }

    static int zeros(int n){
        int cnt =0;
        while (n>=5){
            cnt += n/5;
            n /= 5;
        }
        return cnt;
    }

}
