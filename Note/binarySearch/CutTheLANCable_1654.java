package binarySearch;

import util.Reader;

public class CutTheLANCable_1654 {

    static int[] arr;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        int k = in.nextInt();
        int n = in.nextInt();
        arr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(binarySearch(0, Integer.MAX_VALUE, n));
    }

    static boolean parameterSearch(long key, int n) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= key) {
                sum += arr[i] / key;
            }
        }
        return sum >= n;
    }

    static long binarySearch(long low, long high, int n) {
        long mid, answer = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (parameterSearch(mid, n)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

}
