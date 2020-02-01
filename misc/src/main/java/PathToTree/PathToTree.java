package PathToTree;

import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PathToTree {
    public static void main(String[] args) {
        List<String> paths = readFile("C:\\Java\\Github\\LeetCode\\misc\\src\\main\\resources\\url1.txt");
        List<String> cnts = readFile("C:\\Java\\Github\\LeetCode\\misc\\src\\main\\resources\\cnt1.txt");

        List<JSONObject> tree = createTree(1, paths, cnts, ".");

        System.out.println(tree.toString());

    }

    public static List<String> readFile(String path) {
        List<String> paths = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(new File(path));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                paths.add(line);
            }
            return paths;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<JSONObject> createTree(int level, List<String> paths, List<String> cnts, String delimiter) {
        if (paths == null || paths.size() == 0) return null;

        if (delimiter == null)
            throw new IllegalArgumentException("createTree delimiter can not be null !");

        List<JSONObject> list = new ArrayList<>();
        String pre = null, cur = null, tail = null, cnt = null;
        JSONObject curNode = null;
        List<String> subPaths = new ArrayList<>();
        List<String> subCnts = new ArrayList<>();

        for (int i = 0; i < paths.size(); i++) {
            int index = paths.get(i).indexOf(delimiter);
            if (index >= 0) {
                cur = paths.get(i).substring(0, index);
                tail = paths.get(i).substring(index + delimiter.length());
                cnt = "";
            } else {
                cur = paths.get(i);
                tail = null;
                cnt = cnts.get(i);
            }

            if (pre == null || !pre.equals(cur)) {
                if (subPaths.size() > 0) {
                    curNode.put("nodes", createTree(level + 1, subPaths, subCnts, delimiter));
                    subPaths.clear();
                    subCnts.clear();
                }
                JSONObject node = new JSONObject();
                node.put("level", String.valueOf(level));
                node.put("count", cnt);
                node.put("text", cur);
                if (level == 1) {
                    JSONObject state = new JSONObject();
                    state.put("expanded", false);
                    state.put("selected", false);
                    node.put("state", state);
                }
                list.add(node);
                curNode = node;
                pre = cur;
            }

            if (tail != null) {
                subPaths.add(tail);
                subCnts.add(cnts.get(i));
            }
        }

        if (subPaths.size() > 0) {
            curNode.put("nodes", createTree(level + 1, subPaths, subCnts, delimiter));
            subPaths.clear();
            subCnts.clear();
        }

        return list;
    }
}
