package step14_SetsAndMaps;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;


public class NumberOfDifferentSubstrings_11478 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split("");

        br.close();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            String str = arr[i];

            set.add(str);

            for (int j = i + 1; j < arr.length; j++) {

                str += arr[j];
                set.add(str);
            }

        }

        bw.write(set.size() + "");

        bw.flush();

        bw.close();
    }

}
