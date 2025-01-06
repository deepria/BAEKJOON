package step15_FactorsMultiplesAndDecimals2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FractionSum_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        br.close();

        int c = a1 * b2 + a2 * b1;
        int p = b1 * b2;

        if (c == p) {
            c = 1;
            p = 1;
        } else {
            int max = c > p ? c : p;
            int min = c > p ? p : c;

            int remain = max % min;
            int temp = remain;
            while (remain != 0) {
                remain = min % remain;
                min = temp;
                temp = remain;
            }
            c = c / min;
            p = p / min;
        }

        bw.write(c + " " + p);
        bw.flush();
        bw.close();

    }

}
