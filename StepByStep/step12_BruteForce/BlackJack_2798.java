package step12_BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BlackJack_2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int answer = calc(n, m, arr);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    public static int calc(int n, int m, int[] arr) {

        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int j2 = j + 1; j2 < arr.length; j2++) {
                    if (temp == m) {
                        break;
                    }
                    if (temp <= arr[i] + arr[j] + arr[j2] && arr[i] + arr[j] + arr[j2] <= m) {
                        temp = arr[i] + arr[j] + arr[j2];

                    }

                }

            }

        }

        return temp;
    }

}