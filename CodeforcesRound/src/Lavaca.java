import java.util.*;

public class Lavaca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] a = new int[n];


            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }


            for (int i = 0; i < q; i++) {
                int k = sc.nextInt();
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;

                long ans = 0;
                for (int j = l; j <= r; j++) {
                    while (k % a[j] == 0) {
                        k /= a[j];
                    }
                    ans += k;
                }

                System.out.println(ans);
            }
        }

        sc.close();
    }
}
