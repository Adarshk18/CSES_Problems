import java.io.*;

public class SequenceII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bracketSequence = br.readLine().trim();

        int openCount = 0;  // Tracks unmatched '('
        int closeCount = 0; // Tracks unmatched ')'

        for (char c : bracketSequence.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                if (openCount > 0) {
                    openCount--; // Pair matched, reduce unmatched '(' count
                } else {
                    closeCount++; // Unmatched ')'
                }
            }
        }

        // Total moves = unmatched '(' + unmatched ')'
        System.out.println(openCount + closeCount);
    }
}
