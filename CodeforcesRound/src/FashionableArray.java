import java.util.*;

public class FashionableArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int countEven = 0, countOdd = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
                if (arr[i] % 2 == 0) {
                    countEven++;
                } else {
                    countOdd++;
                }
            }

            if ((min + max) % 2 == 0) {
                System.out.println(0);
            } else {
                System.out.println(Math.min(countEven, countOdd));
            }
        }

        in.close();
    }
}
