package step09_FactorsMultiplesAndDecimals1;

import java.io.*;
import java.util.ArrayList; 
import java.util.StringTokenizer;

public class FindPrimeNumbers_1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

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

        System.out.println(prime.size());

    }
}
