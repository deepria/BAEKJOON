import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

class SearchNum_1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashSet<String> arr = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr.add(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            if (arr.contains(st.nextToken())) {
                bw.write(1 + "\n");

            } else {
                bw.write(0 + "\n");

            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}