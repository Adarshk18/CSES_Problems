import java.util.*;

public class Tournament {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();
        while (t-->0){
            int n= in.nextInt();
            int j = in.nextInt();
            int k = in.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            if (k>1){
                System.out.println("YES");
                continue;
            }

            int ans = a[0];
            for (int i = 1; i < n; i++) {
                if (a[i]>ans) ans = a[i];
            }

            String winner = a[j-1]==ans ? "YES": "No";
            System.out.println(winner);
        }
    }
}
