package step09_FactorsMultiplesAndDecimals1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DivisorFinder_2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            cnt += (n % i == 0) ? 1 : 0;

            if (cnt == k) {
                answer = i;
                break;
            }

        }

        bw.write(answer + "");
        bw.flush();
        bw.close();

    }
}
