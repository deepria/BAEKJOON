import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class BinomialCoefficient_11050 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        br.close();

        int answer = factorial(n) / (factorial(k) * factorial(n - k));

        bw.write(answer + "");

        bw.flush();
        bw.close();

    }

    public static int factorial(int a) {

        int result = 1;

        for (int i = a; i > 0; i--) {
            result *= i;
        }

        return result;
    }

}