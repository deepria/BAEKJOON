package binarySearch;

import util.Reader;

public class CutTheTree_2805 {

    static int[] arr;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        int tree = in.nextInt();
        int need = in.nextInt();
        arr = new int[tree];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(binarySearch(0, 1000000000, need));
    }

    static boolean parameterSearch(long key, int need) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= key) {
                sum += arr[i] - key;
            }
        }
        return sum >= need;
    }

    static long binarySearch(long low, long high, int need) {
        long mid, answer = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (parameterSearch(mid, need)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

}