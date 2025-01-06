import java.util.ArrayList;
import java.util.Arrays;

public class ArrayTest03 {

	public static void main(String[] args) {
		int[] arr = { 5, 9, 7, 10 };
		int[] arr2 = { 3, 6, 9, 3, 1, 2, 5, 9, 4, 8 };
		System.out.println(Arrays.toString(solution(arr2, 3)));

	}

	public static int[] solution(int[] arr, int divisor) {

		int count = 0;

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] % divisor == 0) {

				al.add(arr[i]);
				count++;
			}
		}

		if (count == 0) {
			al.add(0, -1);
		}
		al.remove(null);

		int[] answer = new int[al.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = al.get(i);
		}

		Arrays.sort(answer);

		return answer;
	}

}
