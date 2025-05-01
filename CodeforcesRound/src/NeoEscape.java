import java.util.*;

public class NeoEscape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of buttons
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt(); // Read button weights
            }

            // Initialize the number of clones needed
            int clones = 1;
            int lastPressed = a[0]; // Start with the first button's weight

            // Traverse through the button weights
            for (int i = 1; i < n; i++) {
                if (a[i] > lastPressed) {
                    clones++; // New clone required if current button is greater
                    lastPressed = a[i]; // Reset lastPressed to current weight
                } else {
                    lastPressed = a[i]; // Continue with the same clone
                }
            }

            // Output the minimum number of clones required
            System.out.println(clones);
        }

        sc.close(); // Close scanner
    }
}
