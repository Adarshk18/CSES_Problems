import java.util.Scanner;

public class LRC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            boolean allSame = true;
            a[0] = scanner.nextInt();
            for (int i = 1; i < n; i++) {
                a[i] = scanner.nextInt();
                if (a[i] != a[0]) {
                    allSame = false;
                }
            }
            if (allSame) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
                // Try to split the first element alone
                int gcdB = a[0];
                int gcdC = a[1];
                for (int i = 2; i < n; i++) {
                    gcdC = gcd(gcdC, a[i]);
                }
                if (gcdB != gcdC) {
                    System.out.print("1 ");
                    for (int i = 1; i < n; i++) {
                        System.out.print("2 ");
                    }
                    System.out.println();
                } else {
                    // Try to split the last element alone
                    gcdB = a[n - 1];
                    gcdC = a[0];
                    for (int i = 1; i < n - 1; i++) {
                        gcdC = gcd(gcdC, a[i]);
                    }
                    if (gcdB != gcdC) {
                        for (int i = 0; i < n - 1; i++) {
                            System.out.print("2 ");
                        }
                        System.out.println("1");
                    } else {
                        // Find the first element different from a[0] and split it alone
                        int differentIndex = -1;
                        for (int i = 1; i < n; i++) {
                            if (a[i] != a[0]) {
                                differentIndex = i;
                                break;
                            }
                        }
                        int[] res = new int[n];
                        for (int i = 0; i < n; i++) {
                            res[i] = 2;
                        }
                        res[differentIndex] = 1;
                        System.out.print(res[0]);
                        for (int i = 1; i < n; i++) {
                            System.out.print(" " + res[i]);
                        }
                        System.out.println();
                    }
                }
            }
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}