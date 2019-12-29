import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        List<Integer> list = new LinkedList<>();
        int[] res = new int[temperatures.length];
        int lastIndex = -1;
        for (int i = 0; i < temperatures.length; i++) {
            while (!list.isEmpty() && temperatures[list.get(lastIndex)] < temperatures[i]) {
                res[list.get(lastIndex)] = i - list.get(lastIndex);
                list.remove(lastIndex--);
            }
            list.add(i);
            lastIndex++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};

        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] days = dailyTemperatures.dailyTemperatures(a);
        System.out.println(Arrays.toString(days));
        int[] days2 = dailyTemperatures.dailyTemperatures2(a);
        System.out.println(Arrays.toString(days2));
    }
}
