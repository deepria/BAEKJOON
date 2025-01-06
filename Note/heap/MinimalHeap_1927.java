package heap;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

import util.Reader;

public class MinimalHeap_1927 {

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = in.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();//최소힙(우선순위큐)
        //최대힙(우선순위큐 역순)
        //PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); 
        for (int i = 0; i < n; i++) {
            int next = in.nextInt();
            if (next == 0) {
                bw.write(pq.isEmpty() ? 0 + "\n" : pq.poll() + "\n");
            } else {
                pq.add(next);
            }
        }
        bw.flush();
        bw.close();
    }

}