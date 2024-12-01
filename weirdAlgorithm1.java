import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class weirdAlgorithm1 {
    public static void main(String[] args) throws IOException{
        // Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        // int n = in.nextInt();

        while(n!=1){
            System.out.print(n+ " ");
        if(n%2==0){
            n /=2;
        }else{
           n = 3*n+1;
        }
    }
        System.out.println(n);
    }
}
