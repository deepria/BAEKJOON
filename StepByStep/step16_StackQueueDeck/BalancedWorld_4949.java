package step16_StackQueueDeck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BalancedWorld_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack = new Stack<>();
        String[] arr;
        String str = br.readLine();
        while (!str.equals(".")) {
            arr = str.split("");
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals("(")) {
                    stack.push(arr[j]);
                }
                if (arr[j].equals("[")) {
                    stack.push(arr[j]);
                }
                if (arr[j].equals(")")) {
                    if (stack.empty()) {
                        stack.push(arr[j]);
                        break;

                    } else {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                }
                if (arr[j].equals("]")) {
                    if (stack.empty()) {
                        stack.push(arr[j]);
                        break;
                    } else {
                        if (stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                }
            }
            if (stack.empty() && arr[arr.length - 1].equals(".")) {

                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
            stack.clear();
            str = br.readLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

}