package util;

import java.util.Arrays;

public class TDArrSort {
    public static void main(String[] args) throws Exception {
        int[][] arr = new int[2][2];

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
    }
}
