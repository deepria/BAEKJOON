package step16_StackQueueDeck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class DokiDokiSnackGiver_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        int turn = 1;
        int next;
        while (st.hasMoreElements() || !stack.empty()) {
            while (!stack.empty()) {
                if (turn == stack.peek()) {
                    stack.pop();
                    turn++;
                } else {
                    break;
                }
            }
            if (st.hasMoreElements()) {
                next = Integer.parseInt(st.nextToken());
                if (next == turn) {
                    turn++;
                } else {
                    stack.push(next);
                }
            }
            if (!st.hasMoreElements() && !stack.empty()) {
                if (turn != stack.peek()) {
                    break;
                }
            }
        }
        bw.write(turn == n + 1 ? "Nice" : "Sad");
        bw.flush();
        bw.close();
    }

}