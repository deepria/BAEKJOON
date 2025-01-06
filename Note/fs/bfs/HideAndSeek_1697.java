package fs.bfs;

import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek_1697 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(bfs(n, k));

    }

    static int bfs(int n, int k) {
        if (n == k) {
            return 0;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        BitSet bs = new BitSet(100003);
        int[] line = new int[100003];

        q.add(n);

        while (!q.isEmpty()) {

            int flag = q.poll();

            if (flag == k) {
                break;
            }

            if (flag <= (line.length - 1) / 2 && flag != 0) {
                if (!bs.get(flag * 2)) {
                    line[flag * 2] = line[flag] + 1;
                    q.add(flag * 2);
                    bs.set(flag * 2);
                }
            }
            if (flag < line.length - 1) {
                if (!bs.get(flag + 1)) {
                    line[flag + 1] = line[flag] + 1;
                    q.add(flag + 1);
                    bs.set(flag + 1);
                }
            }

            if (flag > 0) {
                if (!bs.get(flag - 1)) {
                    line[flag - 1] = line[flag] + 1;
                    q.add(flag - 1);
                    bs.set(flag - 1);
                }
            }

        }

        return line[k];

    }
}