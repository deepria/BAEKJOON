
import java.util.Arrays;

public class ArrayTest6 {

	public static void main(String[] args) {
		int[] arr = { 5, 9, 7, 10 };
		int[] arr2 = { 10 };
		System.out.println();

	}

	public static int solution(int[] numbers) {

		int answer = 0;

		Arrays.sort(numbers);

		for (int i = 0; i < numbers.length; i++) {

			answer += numbers[i];

		}

		answer = 45 - answer;

		return answer;
	}

}
