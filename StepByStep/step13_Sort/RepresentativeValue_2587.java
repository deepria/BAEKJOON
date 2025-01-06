package step13_Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepresentativeValue_2587 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];

        }

        br.close();

        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {

                    swap(arr, j, j + 1);

                }
            }

        }
        System.out.println(sum / 5);
        System.out.println(arr[2]);

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}