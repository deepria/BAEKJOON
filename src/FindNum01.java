
public class FindNum01 {

	public static void main(String[] args) {
		System.out.println();

	}

	public static int solution(int n) {
		int answer = 0;

		for (int i = 3; i < n; i++) {
			if (n % i == 1) {
				answer = i;
				break;
			}
		}

		return answer;
	}

}
