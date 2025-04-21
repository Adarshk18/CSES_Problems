import java.io.*;

public class BinaryTypewriter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();


            int originalTransitions = 0;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    originalTransitions++;
                }
            }
            int originalCost = n + originalTransitions;
            if (s.charAt(0) == '1') {
                originalCost += 1;
            }


            int bestCost = originalCost;
            if (originalTransitions > 0) {

                int reducedTransitions = Math.max(originalTransitions - 2, 0);
                int reversedCost = n + reducedTransitions;

                if (s.charAt(0) == '1' && s.charAt(n - 1) == '0') {
                    reversedCost += 1;
                } else if (s.charAt(0) == '0' && s.charAt(n - 1) == '1') {
                    reversedCost += 1;
                } else {
                    reversedCost += (s.charAt(0) == '1' ? 1 : 0);
                }
                bestCost = Math.min(bestCost, reversedCost);
            }

            bw.write(bestCost + "\n");
        }
        bw.flush();
    }
}