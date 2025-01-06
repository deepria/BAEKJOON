package step14_SetsAndMaps;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class PeopleInTheOffice_7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<String, String>();
        String name;
        String state;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            state = st.nextToken();

            if (state.equals("enter")) {
                map.put(name, state);
            } else {
                map.remove(name);
            }

        }
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((s1, s2) -> s2.compareTo(s1));

        for (String string : keySet) {
            bw.write(string + "\n");
        }

        bw.flush();
        bw.close();
    }

}
