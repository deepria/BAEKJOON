package step08_GeneralMath1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CentralMoveAlgorithm_2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();
        int p = 2;
        for (int i = 1; i <= n; i++) {
            p = (int) (p + Math.pow(2, i - 1));
        }

        bw.write(p * p + "");
        bw.flush();
        bw.close();

    }
}
