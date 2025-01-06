package step03_Loop;

import java.io.*;
import java.util.StringTokenizer;

public class APlusB4_10951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = 0, b = 0;
        String line;
        StringTokenizer st;

        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bw.write(a + b + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
