import java.io.*;


public class Apples {
    static final int MOD = 1000000007;


    static long[] fact;
    static long[] invFact;



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] input = br.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        precompute(n+m);

        long ways = comb(n+m-1,m);
        pw.println(ways);
        pw.flush();
    }

    static void precompute(int max){
        fact = new long[max+1];
        invFact = new long[max+1];

        fact[0] = invFact[0] = 1;

        for (int i = 1; i <= max; i++) {
            fact[i] = fact[i-1]*i%MOD;
        }

        invFact[max] = modInverse(fact[max], MOD);
        for (int i = max-1; i >0 ; i--) {
            invFact[i] = invFact[i+1]*(i+1)%MOD;
        }
        invFact[0] = 1;
    }

    //calculate c(a,b) = a!/b!*(a-b)!
    static long comb(int a, int b){
        if (b>a || b<0) return 0;
        return fact[a]*invFact[b]%MOD*invFact[a-b]%MOD;
    }

    static long modInverse(long base, long mod){
        long res = 1;
        long exp = mod-2;


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
