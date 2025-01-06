import java.util.Arrays;

public class ArrayTest01 {

	public static void main(String[] args) {
		long num = 2147483647;
		System.out.println(Arrays.toString(solution(num)));

	}

	public static int[] solution(long n) {

		int length = 0;
		long num = n;
		if (num < 10) {
			length = 1;
		} else {
			while (num != 0) {

				length++;
				num = num / 10;
			}
		}

		long[] arr = new long[length];
		for (int i = 0; i < length; i++) {

			arr[i] = n % 10;
			n = n / 10;

		}

		int[] answer = new int[length];
		for (int i = 0; i < length; i++) {

			answer[i] = (int) arr[i];
			n = n / 10;

		}
		return answer;
	}

}
