import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GCDandLCM_2609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        br.close();

        int gcd = gcd(a, b);

        bw.write(gcd + "\n");
        bw.write(a * b / gcd + "");

        bw.flush();
        bw.close();
    }

    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        return gcd(q, p % q);
    }
}
