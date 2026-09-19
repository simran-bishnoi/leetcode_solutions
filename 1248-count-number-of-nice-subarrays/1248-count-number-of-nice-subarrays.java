class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res=subArr(nums,k)-subArr(nums,k-1);
        return res;
    }

    public int subArr(int nums[],int k){
        if(k<0)return 0;

        int i=0,j=0,cnt=0,ans=0;
        
        while(i<nums.length){
            if(nums[i]%2!=0)cnt++;

            while(cnt>k){
                if(nums[j]%2!=0)cnt--;
                j++;
            }

            ans+=(i-j+1);
            i++;
        }
        return ans;
    }
}