import java.util.*;

public class AliceBob {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while(t-->0){
            int a = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            boolean found = false;

            for (int b = 1; b <= 100; b++) {
                if (b==a) continue;

                if (Math.abs(b-x) < Math.abs(a-x)&&Math.abs(b-y)<Math.abs(a-y)){
                    found = true;
                    break;
                }
            }
            System.out.println(found ? "YES": "NO");
        }
    }
}
