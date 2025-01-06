
public class HarshadTest01 {

	public static void main(String[] args) {
		System.out.println(solution(10));
	}

	public static boolean solution(int x) {
		boolean answer = true;

		int n = 0;
		int y = x;

		while (y != 0) {

			n += (y % 10);
			y = y / 10;
			System.out.println(n);
		}

		if (x % n != 0) {

			answer = false;

		}

		return answer;
	}

}
