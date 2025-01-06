
public class CharTest2 {

	public static void main(String[] args) {
		System.out.println(solution("qwer"));
	}

	public static String solution(String s) {
		String answer = "";

		String[] arr = s.split("");

		if (arr.length % 2 == 0) {
			answer += arr[arr.length / 2 -1];
			answer += arr[arr.length / 2];
		} else {
			answer += arr[arr.length / 2];
		}

		return answer;
	}

}
