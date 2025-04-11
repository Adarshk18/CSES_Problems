import java.util.Scanner;

public class CandyLottery {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.close();

        double expected = 0.0;
        for (int x = 1; x <= k; x++) {
            double prob = Math.pow((double)x / k, n) - Math.pow((double)(x - 1) / k, n);
            expected += x * prob;
        }

        expected = Math.round(expected * 1e6 + 0.5) / 1e6;
        System.out.printf("%.6f\n", expected);
    }
}