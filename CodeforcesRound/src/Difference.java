import java.util.*;

public class Difference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        if (!sc.hasNextInt()) return;
        t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            // Check if string has >= k consecutive '1's
            int consecutive = 0;
            boolean invalid = false;
            for (char ch : s.toCharArray()) {
                if (ch == '1') {
                    consecutive++;
                    if (consecutive >= k) {
                        invalid = true;
                        break;
                    }
                } else {
                    consecutive = 0;
                }
            }

            if (invalid) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");
            int[] result = new int[n];
            List<Integer> zeroPos = new ArrayList<>();
            List<Integer> onePos = new ArrayList<>();

            // Collect indices of 0s and 1s
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') zeroPos.add(i);
                else onePos.add(i);
            }

            int value = n;
            for (int idx : zeroPos) result[idx] = value--;
            for (int idx : onePos) result[idx] = value--;

            // Print permutation
            for (int i = 0; i < n; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(result[i]);
            }
            System.out.println();
        }
        sc.close();
    }
}
