package step11_TimeComplexity;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ExecutionTime3_24264 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long cnt = (long) Math.pow(Integer.parseInt(br.readLine()), 2);

        bw.write(cnt + "\n");
        br.close();
        bw.write(2 + "");
        bw.flush();
        bw.close();
    }

}