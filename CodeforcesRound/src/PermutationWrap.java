import java.util.*;

public class PermutationWrap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println((n * n) / 4 + 1);
        }
    }
}