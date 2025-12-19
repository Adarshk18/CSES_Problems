import java.util.*;

public class MoneySums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] coins = new int[n];
        int maxCoin = 0;
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
            maxCoin += coins[i];
        }

        boolean[] prev = new boolean[maxCoin+1];
        prev[0] = true;

        for(int coin: coins){
            for (int s = maxCoin; s >= coin; s--) {
                prev[s] |= prev[s-coin];
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int s = 1; s <= maxCoin; s++) {
            if (prev[s]) res.add(s);
        }

        System.out.println(res.size());
        for(int x: res) System.out.print(x+" ");
    }
}
