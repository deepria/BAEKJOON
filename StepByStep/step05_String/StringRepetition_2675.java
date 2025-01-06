package step05_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringRepetition_2675 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());

            String[] arr = st.nextToken().split("");

            for (int j = 0; j < arr.length; j++) {

                for (int k = 0; k < n; k++) {
                    sb.append(arr[j]);
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
