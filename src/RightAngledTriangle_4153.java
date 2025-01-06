import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RightAngledTriangle_4153 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        double a = 1, b = 1, c = 1;

        while (a != 0 && b != 0 && c != 0) {

            st = new StringTokenizer(br.readLine(), " ");

            a = Math.pow(Integer.parseInt(st.nextToken()), 2);
            b = Math.pow(Integer.parseInt(st.nextToken()), 2);
            c = Math.pow(Integer.parseInt(st.nextToken()), 2);

            double max = Math.max(a, Math.max(b, c));

            if (max == a && a != 0) {
                if (b + c == a) {
                    bw.write("right\n");
                } else {
                    bw.write("wrong\n");
                }

            } else if (max == b && a != 0) {
                if (a + c == b) {
                    bw.write("right\n");
                } else {
                    bw.write("wrong\n");
                }

            } else if (max == c && a != 0) {
                if (a + b == c) {
                    bw.write("right\n");
                } else {
                    bw.write("wrong\n");
                }

            }

        }

        bw.flush();
        bw.close();
    }
}
