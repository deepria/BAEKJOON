import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class PrimeNum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        br.close();

        int[] arr = new int[n - m + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = m + i;
        }

        ArrayList<Integer> prime = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int cnt = 0;
            for (int j = 2; j <= arr[i]; j++) {
                if (arr[i] % j == 0) {
                    cnt++;
                }
            }
            if (cnt == 1) {
                prime.add(arr[i]);
            }

        }
        int sum = 0;
        for (Integer integer : prime) {
            sum += integer;
        }

        if (prime.size() == 0) {
            System.out.println(-1);
        } else {

            System.out.println(sum);
            System.out.println(prime.get(0));
        }
    }
}
