import java.io.*;
import java.util.*;

public class BitStrings {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        long n = Long.parseLong(br.readLine());

        long res = power(2,n,MOD);
        pw.println(res);
        pw.flush();
    }

    static long power(long base, long exp, long mod){
        long res = 1;
        while (exp>0){
            if((exp & 1)==1){
                res = (res*base)%mod;
            }
            base = (base*base)%mod;
            exp>>=1;
        }
        return res;
    }
}
