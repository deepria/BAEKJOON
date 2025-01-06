package step05_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Constant_2908 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split("");

        int a = Integer.parseInt(arr[2]) * 100 + Integer.parseInt(arr[1]) * 10 + Integer.parseInt(arr[0]);

        int b = Integer.parseInt(arr[6]) * 100 + Integer.parseInt(arr[5]) * 10 + Integer.parseInt(arr[4]);

        System.out.println(Math.max(a, b));

    }

}
