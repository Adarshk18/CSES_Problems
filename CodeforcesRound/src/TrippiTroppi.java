import java.io.*;
import java.util.*;

public class TrippiTroppi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();

        for (int i = 0; i < t; i++) {
            String line = in.nextLine();
            String[] words = line.split(" ");

            String modernName = "" + words[0].charAt(0) + words[1].charAt(0) + words[2].charAt(0);
            System.out.println(modernName);
        }
    }
}
