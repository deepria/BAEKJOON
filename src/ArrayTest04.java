import java.util.ArrayList;
import java.util.Arrays;

public class ArrayTest04 {

	public static void main(String[] args) {
		int[] arr = { 5, 9, 7, 10 };
		int[] arr2 = { 10 };
		System.out.println(Arrays.toString(solution(arr2)));

	}

	public static int[] solution(int[] arr) {

		if (arr.length == 1) {
			int[] answer = { -1 };
			return answer;
		}

		ArrayList<Integer> al = new ArrayList<>();

		int[] arr2 = arr.clone();

		Arrays.sort(arr2);

		int n = arr2[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != n) {
				al.add(arr[i]);
			}

		}

		int[] answer = new int[al.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = al.get(i);
		}

		return answer;
	}

}
