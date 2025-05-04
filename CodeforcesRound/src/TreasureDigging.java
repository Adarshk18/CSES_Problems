import java.util.Scanner;

public class TreasureDigging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            int x = sc.nextInt(); // Little B digs x meters
            int y = sc.nextInt(); // Little K digs y meters
            int a = sc.nextInt(); // Treasure depth is a.5 meters

            double target = a + 0.5; // Treasure is found when depth > a.5
            double depth = 0;
            boolean bTurn = true; // true means Little B's turn

            while (true) {
                if (bTurn) {
                    depth += x;
                    if (depth > target) {
                        System.out.println("NO"); // Little B digs it up
                        break;
                    }
                } else {
                    depth += y;
                    if (depth > target) {
                        System.out.println("YES"); // Little K digs it up
                        break;
                    }
                }
                bTurn = !bTurn; // switch turn
            }
        }

        sc.close();
    }
}
