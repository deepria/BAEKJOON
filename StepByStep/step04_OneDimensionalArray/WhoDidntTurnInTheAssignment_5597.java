package step04_OneDimensionalArray;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WhoDidntTurnInTheAssignment_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[28];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        ArrayList<Integer> List = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            List.add(i + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            List.remove(Integer.valueOf(arr[i]));
        }

        for (Integer integer : List) {
            System.out.println(integer);
        }

    }
}
