import java.io.*;
import java.util.ArrayList;

class polyomino_1343 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split("");
        br.close();

        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr.length == 1) {
                break;
            }

            if (arr[i].equals("X")) {
                cnt++;
            } else if (arr[i].equals(".") && i != 0 && !arr[i - 1].equals(".")) {
                list.add(cnt);
                list.add(0);
                cnt = 0;

            } else {
                list.add(0);
            }

            if (i == arr.length - 1 && cnt != 0) {
                list.add(cnt);
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean is = false;

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) == 0) {
                sb.append(".");
            }

            if (list.get(i) % 2 != 0) {
                is = true;
                break;
            } else {
                if (list.get(i) % 4 == 0) {
                    for (int j = list.get(i); j > 0; j--) {

                        sb.append("A");

                    }
                } else {

                    for (int j = list.get(i); j > 0; j--) {
                        if (j > 2) {
                            sb.append("A");
                        } else {
                            sb.append("B");
                        }
                    }
                }
            }

        }

        if (is) {

            System.out.println(-1);

        } else {
            if (arr.length == 1 && arr[0].equals(".")) {
                System.out.println(".");
            } else if (arr.length == 1 && arr[0].equals("X")) {
                System.out.println(-1);
            } else {
                System.out.println(sb);
            }
        }

    }

}
