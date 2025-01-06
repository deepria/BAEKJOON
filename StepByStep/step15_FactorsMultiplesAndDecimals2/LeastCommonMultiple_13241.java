package step15_FactorsMultiplesAndDecimals2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LeastCommonMultiple_13241 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long max = a > b ? a : b;
        long min = max == a ? b : a;
        long tmp;
        while (max % min != 0) {
            tmp = max % min;
            max = min;
            min = tmp;
        }

        bw.write(a * b / min + "");

        bw.flush();
        bw.close();
    }

}
