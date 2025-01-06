package stack;

import java.util.Stack;

public class StackSequence_1874 {

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();
        int n = in.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        int input, last = 0;
        for (int i = 0; i < n; i++) {
            input = in.nextInt();
            if (stack.empty()) {
                for (int j = last + 1; j <= input; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                last = input;
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.peek().equals(input)) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    for (int j = last + 1; j <= input; j++) {
                        stack.push(j);
                        sb.append("+\n");
                    }
                    last = input;
                    stack.pop();
                    sb.append("-\n");
                }

            }

        }

        System.out.println(stack.empty() ? sb : "NO");
    }
}

class Reader {
    final int SIZE = 1 << 13;
    byte[] buffer = new byte[SIZE];
    int index, size;

    int nextInt() throws Exception {
        int n = 0;
        byte c;
        boolean isMinus = false;
        while ((c = read()) <= 32)
            if (c == 45) {
                c = read();
                isMinus = true;
            }
        do
            n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return isMinus ? ~n + 1 : n;
    }

    boolean isNumber(byte c) {
        return 47 < c && c < 58;
    }

    byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0)
                buffer[0] = -1;
        }
        return buffer[index++];
    }
}
