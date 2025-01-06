package step16_StackQueueDeck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Parenthesis_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        String[] arr;
        for (int i = 0; i < t; i++) {
            arr = br.readLine().split("");
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals("(")) {
                    stack.push(arr[j]);
                } else if (arr[j].equals(")")) {
                    if (stack.empty()) {
                        stack.push(arr[j]);
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.empty()) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
            stack.clear();

        }
        br.close();
        bw.flush();
        bw.close();
    }

}