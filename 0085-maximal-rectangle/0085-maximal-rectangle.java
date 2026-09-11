import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        int[] arr = new int[cols];

        // Initialize the first row (convert char '0'/'1' to int 0/1)
        for (int i = 0; i < cols; i++) {
            arr[i] = matrix[0][i] - '0';
        }

        int ans = maxArea(arr);

        // Process subsequent rows
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    arr[j]++;
                } else {
                    arr[j] = 0;
                }
            }
            ans = Math.max(ans, maxArea(arr));
        }
        return ans;
    }

    public int maxArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        
        for (int i = 0; i <= arr.length; i++) {
            while (!st.isEmpty() && (i == arr.length || arr[st.peek()] >= arr[i])) {
                int height = arr[st.peek()]; // Already an int, no need for - '0'
                st.pop();
                
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                ans = Math.max(ans, width * height);
            }
            st.push(i);
        }
        return ans;
    }
}