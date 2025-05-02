import java.util.Scanner;

public class SUMdamental {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();

            if (n==1){
                if (x==0){
                    System.out.println("-1");
                }else{
                    System.out.println(x);
                }
                continue;
            }

            int y = Integer.bitCount(x);
            if (y>n){
                System.out.println(x);
                continue;
            }

            int ans = x + (n-y);
            if ((n-y)%2!=0) {
                if (x==0 || x==1){
                    ans +=3;
                }else{
                    ans +=1;
                }
            }
            System.out.println(ans);
        }

    }
}
