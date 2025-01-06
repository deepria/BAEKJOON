import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Reader in = new Reader();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        System.out.println(a+b-c);
        System.out.println(a.toString()+b-c);

    }

}

class Reader {
    final int SIZE = 1 << 13;
    byte[] buffer = new byte[SIZE];
    int index, size;

    public int nextInt() throws Exception {
        int n = 0;
        byte c;
        boolean isMinus = false;
        while ((c = read()) <= 32) // { if (size < 0) return -1; }
            ;
        if (c == 45) {
            c = read();
            isMinus = true;
        }
        do
            n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return isMinus ? ~n + 1 : n;
    }


    boolean isNumber(byte c) {
        return 47 < c && c < 58;
    }

    byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0)
                buffer[0] = -1;
        }
        return buffer[index++];
    }
}