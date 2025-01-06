package heap;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

import util.Reader;

public class AbsHeap_11286 {

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = in.nextInt();
        PriorityQueue<number> pq = new PriorityQueue<number>(1, new comparator());
        for (int i = 0; i < n; i++) {
            int next = in.nextInt();
            if (next == 0) {
                bw.write(pq.isEmpty() ? 0 + "\n" : pq.poll().num + "\n");
            } else {
                pq.add(new number(next, (int) Math.abs(next)));
            }
        }
        bw.flush();
        bw.close();
    }

}

class number {
    int num;
    int round;

    public number(int num, int round) {
        this.num = num;
        this.round = round;
    }
}

class comparator implements Comparator<number> {
    public int compare(number o1, number o2) {
        if (o1.round == o2.round) {
            return o1.num - o2.num;
        } else {
            return o1.round - o2.round;
        }
    }
}