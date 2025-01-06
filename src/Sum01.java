//등차수열
public class Sum01 {

	public static void main(String[] args) {
		System.out.println(solution(1, -5));
	}

	public static long solution(long a, long b) {
		long answer = 0;
		if (a == b) {
			return a;
		}
		if (a > b) {
			answer = (a - b + 1) * (b + a) / 2;

		}
		if (a < b) {
			answer = (b - a + 1) * (a + b) / 2;

		}

		return answer;
	}

}
