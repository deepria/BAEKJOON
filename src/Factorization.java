import java.io.*;
import java.util.ArrayList;

class Factorization {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        ArrayList<Integer> list = new ArrayList<Integer>();

        int x = n;

        for (int i = 0; i < x; i++) {

            for (int j = 2; j <= n; j++) {

                if (n % j == 0) {

                    list.add(j);
                    n /= j;

                    break;
                }
            }

        }

        if (x == 1) {

        } else {

            for (Integer integer : list) {
                System.out.println(integer);
            }

        }
    }
}
