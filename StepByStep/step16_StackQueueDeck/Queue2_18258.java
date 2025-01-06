package step16_StackQueueDeck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue2_18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();
        String command;
        int val, last = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken();
            switch (command) {
                case "push":
                    val = Integer.parseInt(st.nextToken());
                    last = val;
                    queue.add(val);
                    break;
                case "pop":
                    bw.write(queue.peek() == null ? -1 + "\n" : queue.poll() + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write(queue.isEmpty() == true ? 1 + "\n" : 0 + "\n");
                    break;
                case "front":
                    bw.write(queue.peek() == null ? -1 + "\n" : queue.peek() + "\n");
                    break;
                case "back":
                    bw.write(queue.peek() == null ? -1 + "\n" : last + "\n");
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

}
