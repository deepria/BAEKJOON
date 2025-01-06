import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ring_3036 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = 0;
        int gcd = 0;

        for (int i = 0; i < n - 1; i++) {

            b = Integer.parseInt(st.nextToken());
            gcd = gcd(a, b);

            bw.write(a / gcd + "/" + b / gcd + "\n");

        }

        br.close();
        bw.flush();
        bw.close();

    }

    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        return gcd(q, p % q);
    }

}