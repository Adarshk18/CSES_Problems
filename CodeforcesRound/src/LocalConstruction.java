import java.io.*;
import java.util.*;
// LocalConstruction

import java.util.*;

public class LocalConstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Replace -1 with (max + 1)
            for (int i = 0; i < n; i++) {
                if (a[i] == -1) {
                    int max = Arrays.stream(a).max().getAsInt();
                    a[i] = max + 1;
                    break;
                }
            }

            int[] ans = new int[n];
            int lo = 1, hi = n;

            for (int j = 1; j < 20; j++) {
                boolean lastEqualToJ = false;
                int lastElementIdx = -1;

                for (int i = n - 1; i >= 0; i--) {
                    if (a[i] < j) continue;
                    if (a[i] == j) lastEqualToJ = true;
                    lastElementIdx = i;
                    break;
                }

                if (lastEqualToJ) {
                    for (int i = lastElementIdx; i >= 0; i--) {
                        if (a[i] < j) continue;
                        if (a[i] > j) break;
                        if (ans[i] == 0) {
                            ans[i] = (j % 2 == 1) ? hi-- : lo++;
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    if (a[i] != j) continue;
                    if (ans[i] != 0) break;
                    ans[i] = (j % 2 == 1) ? hi-- : lo++;
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i]);
                System.out.print(i == n - 1 ? "\n" : " ");
            }
        }
    }
}

