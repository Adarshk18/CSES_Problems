import java.io.*;
import java.util.*;

public class Coefficient {
    static final int MOD = 1000000007;
    static final int MAX = 1000000;
    static long[] fact = new long[MAX+1];
    static  long[] invFact = new long[MAX+1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        preCompute();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pw.println(binomialCoefficient(a,b));
        }
        pw.flush();
    }
    //precompute the factorial and mod in verse
    static void preCompute(){
        fact[0] = 1;
        for (int i = 1; i <=MAX ; i++) {
            fact[i] = (fact[i-1]*i)%MOD;
        }

        //computing modinverse
        invFact[MAX] = modInverse(fact[MAX], MOD);
        for (int i = MAX-1; i >= 0; i--) {
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

    static long binomialCoefficient(int a, int b){
        if (b>a) return 0;
        return (fact[a] * invFact[b]%MOD* invFact[a-b]%MOD)%MOD;
    }

    static long modInverse(long a , long mod){
        return modExp(a,mod-2,mod);
    }

}
