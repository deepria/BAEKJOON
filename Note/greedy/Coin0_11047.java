package greedy;

import util.Reader;

public class Coin0_11047 {

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int coin = 0;
        for (int i = arr.length - 1; i >= 0; i--) {

            coin += k / arr[i];
            k %= arr[i];

        }
        System.out.println(coin);

    }
}