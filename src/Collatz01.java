import java.util.Arrays;

public class Collatz01 {

	public static void main(String[] args) {
		System.out.println(solution(626331));

	}

	public static int solution(int num) {
		int answer = 0;

		long n = (long) num;

		if (n > 1) {

			while (n != 1 && answer < 500) {

				if (n % 2 == 0) {
					n = n / 2;

				} else {
					n = n * 3 + 1;

				}
				answer++;
			}
			if (answer >= 500) {
				answer = -1;
			}

		}

		return answer;
	}

}
