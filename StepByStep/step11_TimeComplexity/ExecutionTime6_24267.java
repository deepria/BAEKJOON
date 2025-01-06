package step11_TimeComplexity;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ExecutionTime6_24267 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        br.close();

        long cnt = 0;

        for (int i = 1; i <= n - 2; i++) {
            cnt += (n - i - 1) * (n - i);
        }

        bw.write(cnt / 2 + "\n");

        bw.write(3 + "");
        bw.flush();
        bw.close();
    }

}
