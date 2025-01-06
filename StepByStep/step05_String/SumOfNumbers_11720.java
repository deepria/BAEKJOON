package step05_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNumbers_11720 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        int sum = 0;

        String[] arr = br.readLine().split("");

        for (int i = 0; i < arr.length; i++) {
            sum += Integer.parseInt(arr[i]);

        }

        System.out.println(sum);

    }

}
