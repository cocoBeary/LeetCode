import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int[] lis(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        int aL = nums.length;
        if (nums.length == 1)
            return nums;

        int[] len = new int[aL];
        Arrays.fill(len, 1);

        int[] pre = new int[aL];
        Arrays.fill(pre, -1);

        for (int i = 1; i < aL; i++)
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    pre[i] = j;
                }
            }

        System.out.println(Arrays.toString(len));
        System.out.println(Arrays.toString(pre));

        int j = 0;
        for (int i = 0; i < aL; i++) {
            if (len[j] < len[i])
                j = i;
        }

        int cnt = len[j];
        int[] ret = new int[cnt];

        while (cnt > 0) {
            ret[--cnt] = nums[j];
            j = pre[j];
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] a = {100, 99, 102, 1, 2, 3, 5, 6, 6, 8, 8, 10, 13, 1, 5, 18};
        // int[] a = { 3, 1, 1, 4, 8, 6, 19, 19, 55, 21, 2, 4, 17, 36, 89, 54}
        System.out.println(Arrays.toString(lis(a)));

//        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
//        System.out.println(test.lengthOfLIS(a));
    }

    // O(n^2)
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int aL = nums.length;
        if (nums.length == 1)
            return 1;

        int[] len = new int[aL];
        Arrays.fill(len, 1);

        for (int i = 1; i < aL; i++)
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                }
            }

        int j = 0;
        for (int i = 0; i < aL; i++) {
            if (len[j] < len[i])
                j = i;
        }

//        Stream<int[]> sorted = Arrays.asList(len).stream().sorted(Comparator.comparing());
//
//        List<int[]> collect = sorted.collect(Collectors.toList());
//
//        System.out.println(collect);
        return len[j];
    }

    // O(NLogN)
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
