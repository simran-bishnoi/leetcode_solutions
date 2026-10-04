class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0]+1>=nums.length)return true;
        if(nums[0]==0)return false;
        int farthest=0;

        for(int i=0; i<nums.length; i++){
            
            if(farthest<i)return false;

            farthest=Math.max(farthest,i+nums[i]);

            if(farthest>=nums.length-1)return true;
        }
        return true;
    }
   
}