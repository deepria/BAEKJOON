package step04_OneDimensionalArray;

import java.io.*;
import java.util.StringTokenizer;

public class Counting_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        int v = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == v) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
