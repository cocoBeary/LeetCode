import java.util.LinkedList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    // ------------ Segment Tree ------------ //
    class SegTreeNode {
        int min, max; // range [min, max]
        int count;
        SegTreeNode left, right;

        public int mid() {
            return ((max + 1 - min) / 2 + min);
        }

        public SegTreeNode(int min, int max) {
            this.min = min;
            this.max = max;
            count = 0;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = min > i ? i : min;
            max = max < i ? i : max;
        }

        SegTreeNode root = new SegTreeNode(min, max);

        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(0, find(nums[i] - 1, root)); // minus 1, in case there will be a equal one
            add(nums[i], root);
        }

        return list;
    }

    private int find(int x, SegTreeNode root) {
        if (root == null) return 0;

        if (x >= root.max) {
            return root.count;
        } else {
            int mid = root.mid();
            if (x < mid) {
                return find(x, root.left);
            } else {
                return find(x, root.left) + find(x, root.right);
            }
        }
    }

    private void add(int x, SegTreeNode root) {
        if (x < root.min || x > root.max) return;

        root.count++;
        if (root.max == root.min) return;

        int mid = root.mid();
        if (x < mid) {
            if (root.left == null) {
                root.left = new SegTreeNode(root.min, mid - 1);
            }
            add(x, root.left);
        } else {
            if (root.right == null) {
                root.right = new SegTreeNode(mid, root.max);
            }
            add(x, root.right);
        }
    }


    // ------------ Binary Indexed Tree ------------ //
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = (nums[i] < min) ? nums[i] : min;
        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i], max);
        }
        int[] tree = new int[max + 1];
        for (int i = nums2.length - 1; i >= 0; i--) {
            res.add(0, get(nums2[i] - 1, tree));
            update(nums2[i], tree);
        }
        return res;
    }

    private int get(int i, int[] tree) {
        int num = 0;
        while (i > 0) {
            num += tree[i];
            i -= i & (-i);
        }
        return num;
    }

    private void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i]++;
            i += i & (-i);
        }
    }

    public static void main(String[] args) {
        int[] m = {5, 2, 6, 1};
        CountOfSmallerNumbersAfterSelf test = new CountOfSmallerNumbersAfterSelf();
        System.out.println(test.countSmaller(m));
    }
}
