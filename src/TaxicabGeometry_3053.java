import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TaxicabGeometry_3053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double r = Double.parseDouble(br.readLine());

        bw.write(r * r * Math.PI + "\n");
        bw.write(r * r * 2 + "\n");

        bw.flush();
        bw.close();
    }
}
