import java.io.*;
import java.util.*;

public class StringCreation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s = br.readLine();

        //since to store unique elements and wants to  maintain sorted order the treeset
        TreeSet<String> permutations = new TreeSet<>();

        // it will convert the string into character
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        int n = s.length();

        boolean[] used = new boolean[n]; // will keep track the current character which is using in making permutation
        generate(chars, "",used, permutations,n);

        pw.println(permutations.size());
        pw.flush();

        for(String perm: permutations){
            pw.println(perm);
        }
        pw.flush();
    }

    public static void generate(char[] chars, String current, boolean[] used, TreeSet<String> permutations, int n){
        if (current.length()==n){
            permutations.add(current);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;

            used[i] = true;
            generate(chars, current + chars[i],used, permutations,n);
            used[i] = false;
        }
    }
}
