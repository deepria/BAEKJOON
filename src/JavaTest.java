
public class JavaTest {

	public static void main(String[] args) {

		System.out.println("12345 :" + solution2(12345).toString());

	}

	public static long solution(long n) {
		long answer = 0;

		answer = -1;
		if ((int) Math.sqrt(n) == Math.sqrt(n)) {
			answer = (int) Math.pow(((int) Math.sqrt(n) + 1), 2);
		}

		return answer;
	}

	public static int[] solution2(long n) {
		int[] answer = new int[1];

		int num = (int) n;
		int arrLength = answer.length;

		while (num != 0) {

			int[] newArr = new int[arrLength + 1];
			for (int i = 0; i < arrLength; i++) {
				newArr[i] = answer[i];
			}

			newArr[arrLength] = (10 - (num % 10));
			num = num / 10;
			arrLength++;
		}

		return answer;

	}
}
