package string;

import util.Reader;

public class IOIOI_5525 {

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        int n = in.nextInt();
        int stringLen = in.nextInt();
        char[] arr = new char[stringLen];
        int[] memo = new int[stringLen];
        int ans = 0;

        for (int i = 0; i < arr.length; i++)
            arr[i] = in.nextChar();

        for (int i = 1; i < stringLen - 1; i++) {
            if (arr[i] == 'O' && arr[i + 1] == 'I') {
                memo[i + 1] = memo[i - 1] + 1;

                if (memo[i + 1] >= n && arr[i - 2 * n + 1] == 'I')
                    ans++;
            }
        }

        System.out.println(ans);

    }

}