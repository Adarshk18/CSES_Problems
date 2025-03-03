import java.util.Scanner;

public class DigitQueries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int q = in.nextInt();
        while(q-->0){
            long k = in.nextLong();
            System.out.println(findDigit(k));
        }
    }

    static char findDigit(long k){
        long len = 1;
        long count = 9;
        long start = 1;

        while (k>len*count){
             k -= len * count;
             len++;
             count *= 10;
             start  *= 10;
        }

        long num = start + (k-1)/len;

        String numstr = Long.toString(num);
        return  numstr.charAt((int)((k-1)%len));
    }
}
