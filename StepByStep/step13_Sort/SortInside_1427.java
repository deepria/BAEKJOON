package step13_Sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SortInside_1427 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split("");

        br.close();

        int[] countArr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            countArr[Integer.parseInt(arr[i])]++;
        }

        for (int i = 1; i < countArr.length; i++) {

            countArr[i] += countArr[i - 1];
        }

        int[] answer = new int[arr.length + 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            int var = Integer.parseInt(arr[i]);
            countArr[var]--;
            answer[countArr[var]] = var;

        }

        for (int i = answer.length - 2; i >= 0; i--) {
            bw.write(answer[i] + "");
        }

        bw.flush();
        bw.close();

    }

}