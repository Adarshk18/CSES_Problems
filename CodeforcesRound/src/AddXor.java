import java.util.*;

public class AddXor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-->0){
            int a = in.nextInt();
            int b = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            if (a==b){
                System.out.println(0);
            }else if(a < b){
                int c1 = (b-a)*x;
                int cc1 = Integer.MAX_VALUE;
                int ac = a ^ 1;
                if (ac <= b){
                    cc1 = y + (b-ac)*x;
                }

                int ap = a+1;
                int apx = ap ^ 1;
                if (apx <= b) {
                    cc1 = Math.min(cc1, x + y + (b - apx) * x);
                }
                System.out.println(Math.min(c1, cc1));
            }else{
                if ((a^1)==b){
                    System.out.println(y);
                }else{
                    System.out.println(-1);
                }
            }
        }
        in.close();
    }
}
