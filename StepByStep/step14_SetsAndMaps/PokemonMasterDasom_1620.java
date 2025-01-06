package step14_SetsAndMaps;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PokemonMasterDasom_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>(n);
        HashMap<String, String> map2 = new HashMap<>(n);

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            map.put(Integer.toString(i), input);
            map2.put(input, Integer.toString(i));
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();

            try {
                bw.write(map.get(str));
                bw.write("\n");

            } catch (NullPointerException e) {
                bw.write(map2.get(str));
                bw.write("\n");
            }

        }

        br.close();

        bw.flush();
        bw.close();
    }

}
