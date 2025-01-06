package step06_Advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KingQueen_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] white = new int[6];
        for (int i = 0; i < white.length; i++) {
            white[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[6];
        answer[0] = 1 - white[0];
        answer[1] = 1 - white[1];
        answer[2] = 2 - white[2];
        answer[3] = 2 - white[3];
        answer[4] = 2 - white[4];
        answer[5] = 8 - white[5];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}
