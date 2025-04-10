import java.io.*;
import java.util.*;

public class SkibidiTable {

    interface FindXY {
        int apply(int x, int y, int sz, int value);
    }

    interface FindD {
        int[] apply(int x, int y, int sz, int value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            while (q-- > 0) {
                // Read a new line for each query
                st = new StringTokenizer(br.readLine());
                String type = st.nextToken();

                if (type.equals("->")) {
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());

                    int finalR = r;
                    int finalC = c;

                    FindXY[] findXY = new FindXY[1];
                    findXY[0] = (x, y, sz, value) -> {
                        if (sz == 1) {
                            assert finalR == x && finalC == y;
                            return value;
                        }

                        int subTotal = (sz * sz) / 4;
                        int nsz = sz / 2;
                        int[] dx = {0, nsz, nsz, 0};
                        int[] dy = {0, nsz, 0, nsz};

                        for (int i = 0; i < 4; i++) {
                            int nx = x + dx[i];
                            int ny = y + dy[i];

                            if (finalR >= nx && finalR < nx + nsz && finalC >= ny && finalC < ny + nsz) {
                                int nvalue = value + subTotal * i;
                                return findXY[0].apply(nx, ny, nsz, nvalue);
                            }
                        }
                        return -1;
                    };

                    System.out.println(findXY[0].apply(1, 1, 1 << n, 1));
                } else {
                    int d = Integer.parseInt(st.nextToken());

                    FindD[] findD = new FindD[1];
                    findD[0] = (x, y, sz, value) -> {
                        if (sz == 1) {
                            assert d == value;
                            return new int[]{x, y};
                        }

                        int subTotal = (sz * sz) / 4;
                        int nsz = sz / 2;

                        for (int i = 0; i < 4; i++) {
                            int nvalue = value + subTotal * i;
                            if (d >= nvalue && d < nvalue + subTotal) {
                                switch (i) {
                                    case 0: return findD[0].apply(x, y, nsz, nvalue);
                                    case 1: return findD[0].apply(x + nsz, y + nsz, nsz, nvalue);
                                    case 2: return findD[0].apply(x + nsz, y, nsz, nvalue);
                                    case 3: return findD[0].apply(x, y + nsz, nsz, nvalue);
                                }
                            }
                        }
                        return new int[]{-1, -1};
                    };

                    int[] res = findD[0].apply(1, 1, 1 << n, 1);
                    System.out.println(res[0] + " " + res[1]);
                }
            }
        }
    }
}