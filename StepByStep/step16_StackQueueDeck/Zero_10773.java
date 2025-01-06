package step16_StackQueueDeck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Zero_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int n;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sum -= stack.pop();
            } else {
                sum += stack.push(n);
            }
        }
        br.close();
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }

}