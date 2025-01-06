package squareNumberLaw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DistributedProcessing_1009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // 제곱수의 첫자리는 각배열[승수%4] 이다.
        int[] two = { 6, 2, 4, 8 };
        int[] three = { 1, 3, 9, 7 };
        int[] seven = { 1, 7, 9, 3 };
        int[] eight = { 6, 8, 4, 2 };
        int a, b, c;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            switch (a % 10) {
                case 0:
                    // 10의 제곱수의 첫자리는 항상 0이다.
                    bw.write(10 + "\n");
                    break;
                case 1, 5, 6:
                    // 1,5,6의 제곱수의 첫자리는 항상 자기 자신이다.
                    bw.write(a % 10 + "\n");
                    break;
                case 2:
                    c = b % 4;
                    bw.write(two[c] + "\n");
                    break;
                case 3:
                    c = b % 4;
                    bw.write(three[c] + "\n");
                    break;
                case 4:
                    c = b % 2;
                    // 4의 제곱수의 첫자리는 승수가 홀수일때 4 짝수일때 6이다.
                    bw.write(c == 1 ? 4 + "\n" : 6 + "\n");
                    break;
                case 7:
                    c = b % 4;
                    bw.write(seven[c] + "\n");
                    break;
                case 8:
                    c = b % 4;
                    bw.write(eight[c] + "\n");
                    break;
                case 9:
                    c = b % 2;
                    // 9의 제곱수의 첫자리는 승수가 홀수일때 9 짝수일때 1이다.
                    bw.write(c == 1 ? 9 + "\n" : 1 + "\n");
                    break;

            }

        }

        bw.flush();
        bw.close();
    }

}
