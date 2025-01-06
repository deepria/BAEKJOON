package step14_SetsAndMaps;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UnheardOfBastard_1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n + m];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }
        br.close();

        Arrays.sort(arr);

        int cnt = 0;

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].equals(arr[i])) {
                list.add(arr[i]);
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        for (String string : list) {
            bw.write(string + "\n");
        }

        bw.flush();

        bw.close();
    }

}
