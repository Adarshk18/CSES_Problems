

import java.util.Scanner;

public class missingNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long totNumber = (long) n*(n+1)/2;
        long givenSum =0;
        for(int i=0; i<n-1; i++){
            givenSum += in.nextInt();
        }
        System.out.println(totNumber-givenSum);

    }
}
