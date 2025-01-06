package step12_BruteForce;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class decompositionSum_2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        br.close();
        int answer;

        answer = calc(n);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    public static int calc(int n) {

        int temp = 0;

        for (int i = n - 9 * Integer.toString(n).length(); i <= n; i++) {

            for (int j = 0; j < Integer.toString(n).length(); j++) {
                temp += (int) (i / Math.pow(10, j)) % 10;

            }

            temp += i;

            if (temp == n) {
                temp = i;
                break;
            } else {
                temp = 0;
            }
        }

        return temp;

    }

}