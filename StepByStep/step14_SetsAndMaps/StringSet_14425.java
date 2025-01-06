package step14_SetsAndMaps;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StringSet_14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];

        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }

        String[] arrM = new String[m];

        for (int i = 0; i < arrM.length; i++) {
            arrM[i] = br.readLine();
        }

        for (int i = 0; i < arrM.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (arrM[i].equals(arr[j])) {
                    cnt++;
                    break;
                }

            }

        }
        br.close();

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

}
