import java.util.*;

public class Square1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-->0){
            String s = in.next();
            int n = Integer.parseInt(s);

            double sqrt = Math.sqrt(n);
            int x = (int) sqrt;

            if ((long)x*x!=n){
                System.out.println("-1");
            }else{
                int a = Integer.parseInt(s.substring(0,2));
                int b = Integer.parseInt(s.substring(2,4));

                if (a+b==x){
                    System.out.println(a + " " + b);
                }else{
                    System.out.println("0 " + x);
                }
            }
        }
    }
}
