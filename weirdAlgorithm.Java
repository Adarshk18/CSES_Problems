import java.io.*;


class weirdAlgorithm{
    public static void main(String[] args) throws IOException{
        // Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseLong(br.readLine().trim());
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