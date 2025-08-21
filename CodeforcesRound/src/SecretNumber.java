import java.util.*;

public class SecretNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        long[] pow10 = new long[19];
        pow10[0] = 1L;
        for (int i = 1; i <= 18; i++) {
            pow10[i] = pow10[i-1] * 10L;
        }


        while (t-->0){
            long n = in.nextLong();

            List<Long> xs = new ArrayList<>();
            for (int k = 1; k <= 18; k++) {
                long d = pow10[k]+1;
                if (n%d==0){
                    long x = n/d;
                    if (x>0) xs.add(x);
                }
            }

            if (xs.isEmpty()){
                System.out.println(0);
            }else{
                Collections.sort(xs);
                System.out.println(xs.size());
                for (int i = 0; i < xs.size(); i++) {
                    if (i>0) System.out.print(" ");
                    System.out.print(xs.get(i));
                }
                System.out.println();
            }
        }
    }
}
