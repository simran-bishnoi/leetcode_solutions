class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
     
        int ans=subArr(nums,goal)-subArr(nums,goal-1);
        return ans;
    }

    public int subArr(int nums[],int goal){

        if(goal<0)return 0;

        int i=0,j=0,ans=0,sum=0;

        while(i<nums.length){
            sum+=nums[i];

            while(sum>goal){
                sum-=nums[j++];
            }
            ans=ans+(i-j+1);
            i++;
        }
        return ans;
    }
}