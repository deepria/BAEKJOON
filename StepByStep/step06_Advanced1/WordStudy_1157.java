package step06_Advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class WordStudy_1157 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().toUpperCase().split("");

        Arrays.sort(arr);

        ArrayList<String> list = new ArrayList<>();

        String str = arr[0];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {

            if (str.equals(arr[i])) {
                sb.append(str);

            } else {
                list.add(sb.toString());
                str = arr[i];
                sb = new StringBuilder();
                sb.append(str);

            }

            if (i == arr.length - 1) {
                list.add(sb.toString());
            }

        }

        String[] answerArr = list.toArray(new String[list.size()]);

        Arrays.sort(answerArr, Comparator.comparing(String::length).reversed());

        String string;
        if (arr.length == 1) {
            string = arr[0];

        } else if (answerArr[0].length() == answerArr[1].length()) {
            string = "?";
        } else {
            string = answerArr[0];
        }

        System.out.println(string.charAt(0));

    }

}
