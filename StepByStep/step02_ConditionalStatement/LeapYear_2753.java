package step02_ConditionalStatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeapYear_2753 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int answer = 0;

        if (a % 4 == 0) {
            answer = 1;
        }
        if (a % 100 == 0) {
            answer = 0;
        }
        if (a % 400 == 0) {
            answer = 1;
        }

        System.out.println(answer);
    }
}
