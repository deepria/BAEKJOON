package step03_Loop;

import java.io.*;
import java.util.StringTokenizer;

public class APlusB8_11022 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append("Case #" + (i + 1) + ": " + a + " + " + b + " = " + (a + b) + "\n");

        }

        System.out.print(sb);
    }
}