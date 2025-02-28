import java.io.*;
import java.util.*;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s = br.readLine();
        int n = s.length();

        // Create frequency array
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'A']++;
        }

        // Check if a palindrome is possible
        int oddCount = 0;
        char oddChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                oddChar = (char) (i + 'A');
            }
        }

        // If more than one character has an odd frequency, no palindrome is possible
        if (oddCount > 1) {
            pw.println("NO SOLUTION");
            pw.flush();
            return;
        }

        // Construct the left half of the palindrome
        StringBuilder left = new StringBuilder();
        for (char c : s.toCharArray()) {
            // Append the character if it hasn't been fully used yet
            if (freq[c - 'A'] > 1) {
                left.append(c);
                freq[c - 'A'] -= 2;
                // Reduce frequency by 2 (since we're using two characters)
            }
        }

        // Construct the right half by reversing the left half
        String right = left.reverse().toString();
        left.reverse(); // Restore the original left half

        // Append the middle character if there is one
        String middle = (oddCount == 1) ? String.valueOf(oddChar) : "";

        // Combine left, middle, and right to form the palindrome
        String palindrome = left.toString() + middle + right;
        pw.println(palindrome);
        pw.flush();
    }
}




