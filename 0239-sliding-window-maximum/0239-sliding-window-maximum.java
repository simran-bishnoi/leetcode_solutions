import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int l = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove elements from the back that are smaller than the current element
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // Add current index to the back
            dq.offerLast(i);

            // Record the maximum for the current window once the first window is complete
            if (i >= k - 1) {
                ans[l] = nums[dq.peekFirst()];
                l++;
            }
        }
        return ans;
    }
}