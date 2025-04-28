import java.util.*;

public class UnpleasantStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the inputs
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();  // Consume the newline character
        String s = sc.nextLine();
        int q = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        // Preprocess the string s
        // positions[c] will store the list of positions where character c appears in s
        List<Integer>[] positions = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            positions[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            positions[s.charAt(i) - 'a'].add(i);
        }

        // For each query, process the string ti
        for (int i = 0; i < q; i++) {
            String t = sc.nextLine();
            int answer = minLettersToMakeUnpleasant(t, positions, k);
            System.out.println(answer);
        }

        sc.close();
    }

    private static int minLettersToMakeUnpleasant(String t, List<Integer>[] positions, int k) {
        int m = t.length();

        // The last valid position in s where we are looking for each character
        int lastPos = -1;

        // Iterate over each character in t and check if we can find it in the positions list of s
        for (int i = 0; i < m; i++) {
            char currentChar = t.charAt(i);
            int charIndex = currentChar - 'a';

            if (charIndex >= k) {
                return m - i;  // If the character is beyond the allowed characters
            }

            List<Integer> posList = positions[charIndex];
            int nextPos = findNextPos(posList, lastPos);

            if (nextPos == -1) {
                // If we cannot find the character at a valid position
                return m - i;  // This means we need to append (m - i) letters to make it unpleasant
            }

            // Move to the next position for the next character in the subsequence
            lastPos = nextPos;
        }

        // If we successfully process the entire string t as a subsequence, return 0
        return 0;
    }

    // Binary search to find the next valid position greater than `lastPos`
    private static int findNextPos(List<Integer> posList, int lastPos) {
        int low = 0;
        int high = posList.size() - 1;
        int result = -1;

        // Binary search for the smallest index with value greater than lastPos
        while (low <= high) {
            int mid = (low + high) / 2;
            if (posList.get(mid) > lastPos) {
                result = posList.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}
