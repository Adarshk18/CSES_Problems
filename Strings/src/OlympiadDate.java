import java.util.*;

public class OlympiadDate {
    static final int[] target = {0,1,0,3,2,0,2,5}; // Digits in "01032025"

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        Map<Integer, Integer> targetFreq = new HashMap<>();
        for (int d : target) {
            targetFreq.put(d, targetFreq.getOrDefault(d, 0) + 1);
        }

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] digits = new int[n];
            for (int i = 0; i < n; i++) {
                digits[i] = sc.nextInt();
            }

            Map<Integer, Integer> freq = new HashMap<>();
            int answer = 0;

            for (int i = 0; i < n; i++) {
                freq.put(digits[i], freq.getOrDefault(digits[i], 0) + 1);
                if (hasAllRequiredDigits(freq, targetFreq)) {
                    answer = i + 1;
                    break;
                }
            }

            System.out.println(answer);
        }
    }

    static boolean hasAllRequiredDigits(Map<Integer, Integer> current, Map<Integer, Integer> target) {
        for (Map.Entry<Integer, Integer> entry : target.entrySet()) {
            int digit = entry.getKey();
            int requiredCount = entry.getValue();
            if (current.getOrDefault(digit, 0) < requiredCount) {
                return false;
            }
        }
        return true;
    }
}
