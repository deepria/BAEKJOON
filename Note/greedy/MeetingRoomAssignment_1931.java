package greedy;

import java.util.Arrays;

import util.Reader;

public class MeetingRoomAssignment_1931 {

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int answer = 1;
        int end = arr[0][1];
        for (int j = 1; j < n; j++) {
            if (arr[j][0] >= end) {
                end = arr[j][1];
                answer++;
            }
        }

        System.out.println(answer);

    }
}
