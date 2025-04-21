import java.util.*;

public class GrundyGame {
    static final int MAXN = (int) 1e6 + 1;
    static int[] grundy = new int[MAXN];

    static void init() {
        for (int i = 0; i < MAXN; i++) {
            grundy[i] = (i % 2 == 0) ? 0 : 1; // Even: second, Odd: first
        }
    }

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        long T = sc.nextInt();
        while (T-- > 0) {
            long N = sc.nextInt();
            System.out.println(grundy[(int) N] == 0 ? "first" : "second");
        }
        sc.close();
    }
}