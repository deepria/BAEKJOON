
public class CharTest3 {

	public static void main(String[] args) {
		System.out.println(solution(5));
	}

	public static String solution(int n) {
		String answer = "";

		for (int i = 1; i < n + 1; i++) {
			answer += i % 2 == 0 ? "박" : "수";
		}
		return answer;
	}

}
