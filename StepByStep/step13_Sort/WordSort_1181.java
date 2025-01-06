package step13_Sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class WordSort_1181 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                int x = 0;
                for (int i = 0; i < o1.length(); i++) {

                    if (o1.codePointAt(i) != o2.codePointAt(i)) {
                        x = i;
                        break;
                    }

                }
                return Integer.compare(o1.codePointAt(x), o2.codePointAt(x));
            } else {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1 && arr[i].equals(arr[i + 1])) {
                arr[i] = "";
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > 0) {

                bw.write(arr[i] + "\n");
            }

        }

        bw.flush();
        bw.close();

    }

}