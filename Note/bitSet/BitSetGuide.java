package bitSet;

import java.util.BitSet;

public class BitSetGuide {

    public static void main(String[] args) throws Exception {

        BitSet[] bs = new BitSet[10];
        for (int i = 0; i < bs.length; i++) {
            bs[i] = new BitSet();
            bs[i].set(0);
            bs[i].set(1);
            bs[i].flip(1);
        }
        System.out.println();
        for (int i = 0; i < bs.length; i++) {
            System.out.print(bs[i].get(0) + " ");
            System.out.print(bs[i].get(1) + " ");
            System.out.println();
        }
    }
}