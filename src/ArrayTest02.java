import java.util.Arrays;

public class ArrayTest02 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(2, 5)));

	}

	public static long[] solution(int x, int n) {
		long[] answer = new long[n];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = (long) x * (i + 1);
		}

		return answer;
	}

}
