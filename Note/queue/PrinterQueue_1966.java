package queue;

import java.util.LinkedList;

import util.Reader;

public class PrinterQueue_1966 {

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();
        int c = in.nextInt();

        for (int t = 0; t < c; t++) {
            int n = in.nextInt();
            int m = in.nextInt();
            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                q.offer(new int[] { i, in.nextInt() });
            }
            int cnt = 0;
            while (!q.isEmpty()) {

                int[] front = q.poll();
                boolean isMax = true;

                for (int i = 0; i < q.size(); i++) {
                    if (front[1] < q.get(i)[1]) {
                        q.offer(front);
                        for (int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                if (isMax == false) {
                    continue;
                }
                cnt++;
                if (front[0] == m) {
                    break;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

}
