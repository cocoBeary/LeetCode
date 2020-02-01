import java.util.Stack;

/**
 * 85. Maximal Rectangle
 * Hard
 *
 * Share
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 * Hint: based on 84. Largest Rectangle in Histogram
 */

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int height = matrix.length;
        int width = matrix[0].length;

        int max = 0;
        int[] h = new int[width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                h[j] = matrix[i][j] == '1' ? h[j] + 1 : 0;
            }
            max = Math.max(max, largestRectangleArea(h));
        }
        return max;
    }

    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            while (!s.isEmpty() && h < height[s.peek()]) {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
            }
            s.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        //char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'1', '0'}};
        MaximalRectangle test = new MaximalRectangle();
        System.out.println(test.maximalRectangle(matrix));
    }
}
