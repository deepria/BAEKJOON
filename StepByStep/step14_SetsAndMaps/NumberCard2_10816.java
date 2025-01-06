package step14_SetsAndMaps;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NumberCard2_10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[20000001];

        for (int i = 0; i < n; i++) {
            arr[(Integer.parseInt(st.nextToken()) + 10000000)]++;

        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            bw.write(arr[(Integer.parseInt(st.nextToken()) + 10000000)] + " ");

        }

        br.close();

        bw.flush();
        bw.close();
    }

}
