import java.util.Scanner;

public class DinnerTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();

           if (n%p==0){
               if (m == q*n/p){
                   System.out.println("YES");
               }else{
                   System.out.println("NO");
               }
           }else{
               System.out.println("YES");
           }
}

    }
}