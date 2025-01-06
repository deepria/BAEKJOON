package step08_GeneralMath1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DonghyukTheLaundryOwner_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int c;
        int q;
        int d;
        int n;
        int p;

        for (int i = 0; i < t; i++) {
            c = Integer.parseInt(br.readLine());
            q = c / 25;
            d = (c - q * 25) / 10;
            n = (c - q * 25 - d * 10) / 5;
            p = c - q * 25 - d * 10 - n * 5;
            bw.write(q + " " + d + " " + n + " " + p + "\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }
}
