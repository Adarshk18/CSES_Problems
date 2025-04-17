import java.io.*;
import java.util.*;

public class RobotProgram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());  // Large input constraint

            String s = br.readLine();

            HashMap<Integer, Integer> positionMap = new HashMap<>();
            int currPosition = x;
            int zeroCount = 0;

            // Simulate the first cycle
            for (int i = 0; i < n; i++) {
                if (currPosition == 0) zeroCount++; // Count zero occurrences
                positionMap.put(currPosition, positionMap.getOrDefault(currPosition, 0) + 1);

                if (s.charAt(i) == 'L') currPosition--;
                else currPosition++;
            }

            if (currPosition == 0) zeroCount++; // If cycle ends at 0, count it

            int displacement = currPosition - x;

            if (displacement == 0) {
                // If the robot ends where it started, the cycle repeats identically
                pw.println(zeroCount * (k / n));
            } else {
                // If displacement is nonzero, simulate additional cycles
                long totalZeroes = zeroCount;
                long cycles = k / n;
                long remainingSteps = k % n;

                // Process remaining steps after full cycles
                currPosition = x;
                for (int i = 0; i < remainingSteps; i++) {
                    if (currPosition == 0) totalZeroes++;
                    if (s.charAt(i) == 'L') currPosition--;
                    else currPosition++;
                }

                pw.println(totalZeroes + (zeroCount * cycles));
            }
        }

        pw.flush();
    }
}
