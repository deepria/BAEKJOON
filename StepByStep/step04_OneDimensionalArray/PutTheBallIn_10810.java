package step04_OneDimensionalArray;

import java.io.*;
import java.util.*;

public class PutTheBallIn_10810 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int x = 0; x < m; x++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken());

            for (int y = i; y <= j; y++) {
                arr[y] = k;
            }
        }
        br.close();

        for (int i : arr) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();

    }

}