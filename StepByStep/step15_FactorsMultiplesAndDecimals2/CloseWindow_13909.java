package step15_FactorsMultiplesAndDecimals2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CloseWindow_13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        br.close();
        boolean arr[] = new boolean[n + 1];
        int cnt = 0;

        for (int i = 2; i <= n; i++) {

            arr[i] = arr[i] ? false : true;
            // bw.write("i : " + i + " arr[i] : " + arr[i] + "\n");

            for (int j = i + i; j <= n; j = j + i) {
                arr[j] = arr[j] ? false : true;
                // bw.write("j : " + j + " arr[j] : " + arr[j] + "\n");
            }
            // bw.write("\n");
            for (int x = 1; x < arr.length; x++) {
                if (arr[x]) {
                    // bw.write("X ");
                } else {
                    // bw.write("O ");
                }

            }
            bw.write("\n");
        }
        for (int i = 1; i <= n; i++) {
            if (i < 10) {
                // bw.write(i + " ");
            } else {
                // bw.write(i + "");
            }
            if (!arr[i]) {
                cnt++;
            }

        }
        bw.write("\n" + cnt);

        bw.flush();
        bw.close();
    }

}
/*
 * 위 코드로 수열 발견 후 아래코드 제출 및 통과
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Temp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int temp = 1;
        int plus = 3;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            temp += plus;
            plus += 2;
            if (temp > n) {
                answer = i;
                break;
            }

        }
        bw.write(answer + "");
        bw.flush();
        bw.close();

    }

}
*/
