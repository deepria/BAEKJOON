package step05_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfWords_1152 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int answer = arr.length;

        if (arr.length != 0) {

            if (arr[0].equals("")) {
                answer--;
            }
            if (arr[arr.length - 1].equals("")) {
                answer--;
            }

        }

        System.out.println(answer);
    }

}
