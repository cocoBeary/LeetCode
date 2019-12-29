import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        return find(n, n);
    }

    List<String> find(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(("")));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        List<String> list = find(n - 2, m);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String a = list.get(i);

            if (m != n) res.add("0" + a + "0");
            res.add("1" + a + "1");
            res.add("6" + a + "9");
            res.add("8" + a + "8");
            res.add("9" + a + "6");
        }
        return res;
    }
}
