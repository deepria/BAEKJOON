package step13_Sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CoordinateCompression_18870 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < arr.length; i++) {

            arr[i] = Integer.parseInt(st.nextToken());

        }

        br.close();

        TreeSet<Integer> set = new TreeSet<Integer>(Arrays.asList(arr));

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(set.pollFirst(), i);
        }

        for (int i = 0; i < arr.length; i++) {

            bw.write(map.get(arr[i]) + " ");

        }

        bw.flush();
        bw.close();

    }

}