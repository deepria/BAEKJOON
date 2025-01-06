
public class WhereIsKim {

	public static void main(String[] args) {

	}

	public String solution(String[] seoul) {
		String answer = "";
		int n = 0;
		String str = "Kim";

		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals(str)) {
				n = i;
				break;
			}
		}

		answer = "김서방은 " + n + "에 있다";
		return answer;
	}

}
