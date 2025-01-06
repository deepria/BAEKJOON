package step02_ConditionalStatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PickQuadrant_14681 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int answer = 0;

        if (x > 0 && y > 0) {
            answer = 1;
        }
        if (x < 0 && y > 0) {
            answer = 2;
        }
        if (x < 0 && y < 0) {
            answer = 3;
        }
        if (x > 0 && y < 0) {
            answer = 4;
        }

        System.out.println(answer);
    }
}
