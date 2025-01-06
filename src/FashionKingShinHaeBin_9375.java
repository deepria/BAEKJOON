import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FashionKingShinHaeBin_9375 {
    static long beforeTime = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                bw.write(0 + "\n");
                continue;
            }

            String[] arr = new String[n];

            for (int j = 0; j < arr.length; j++) {

                st = new StringTokenizer(br.readLine(), " ");

                String temp = st.nextToken();
                arr[j] = st.nextToken();

            }

            Arrays.sort(arr);

            int temp = 0;
            int answer = 1;
            String str = arr[0];

            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals(str)) {
                    temp++;
                } else if (!arr[j].equals(str)) {
                    answer *= (temp + 1);
                    temp = 1;
                    str = arr[j];
                }
                if (j == arr.length - 1) {
                    answer *= (temp + 1);
                }

            }

            answer--;

            bw.write(answer + "\n");

        }

        br.close();

        bw.flush();
        bw.close();

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);

    }

}