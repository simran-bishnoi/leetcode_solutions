class Solution {
    public int longestOnes(int[] nums, int k) {
        if(k==nums.length)return k;
        int j=0,zero=0,maxlen=0,i=0;

        while(i<nums.length){
            if(nums[i]==0)zero++;

            while(zero>k){
               
                if(j<nums.length && nums[j]==0){
                    zero--; 
                }
                j++;
               }
            
            maxlen=Math.max(i-j+1,maxlen);
           
            i++;
        }
        return maxlen;
    }
}