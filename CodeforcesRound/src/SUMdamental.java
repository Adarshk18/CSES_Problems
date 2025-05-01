import java.util.Scanner;

public class SUMdamental {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            if (n == 1) {
                System.out.println(x != 0 ? x : -1);
            } else if (n == 2) {
                if (x == 0) {
                    System.out.println(2);
                } else if (x == 1) {
                    System.out.println(5);
                } else {
                    System.out.println(x + 3);
                }
            } else {
                if (x == 0) {
                    if (n % 2 == 1) {
                        System.out.println(n + 3);
                    } else {
                        System.out.println(n);
                    }
                } else {
                    if (n % 2 == 1) {
                        System.out.println(n - 1 + x);
                    } else {
                        System.out.println(n - 2 + x);
                    }
                }
            }
        }
        sc.close();
    }
}