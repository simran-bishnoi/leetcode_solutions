class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int target = totalSum - x;
        if (target < 0) return -1; // x is greater than total sum
        
        int n = nums.length;
        int maxLen = -1;
        int currentSum = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            currentSum += nums[right];
            
            // Shrink window from left if current sum exceeds target
            while (currentSum > target && left <= right) {
                currentSum -= nums[left++];
            }
            
            // Record valid window length
            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen == -1 ? -1 : n - maxLen;
    }
}