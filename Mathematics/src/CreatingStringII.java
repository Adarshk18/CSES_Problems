import java.io.*;
import java.util.*;

public class CreatingStringII {
    static final int MOD = 1000000007;
    static final int MAX = 1000000;
    static long[] fact = new long[MAX+1];
    static long[] invFact = new long[MAX+1];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s = br.readLine();
        int n = s.length();

        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        preCompute();
        long res = fact[n];
        for (int i = 0; i < 26; i++) {
            if (freq[i]>0){
                res = (res * invFact[freq[i]])%MOD;
            }
        }
        pw.println(res);
        pw.flush();
    }

    static void preCompute(){
        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = (fact[i-1]*i)%MOD;
        }

        invFact[MAX] = modExp(fact[MAX],MOD-2,MOD );
        for (int i = MAX-1; i >=0 ; i--) {
            invFact[i] = (invFact[i+1]*(i+1))%MOD;
        }
    }

    static long modExp(long base, long exp, long mod){
        long res = 1;
        while(exp>0){
            if ((exp&1)==1){
                res = (res*base)%mod;
            }
            base = (base*base)%mod;
            exp>>=1;
        }
        return res;
    }
}
