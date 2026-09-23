class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans=subArr(nums,k)-subArr(nums,k-1);
        return ans;
    }
    public int subArr(int nums[],int k){
        if(k<0)return 0;
        HashMap<Integer,Integer>map=new HashMap<>();
        int count=0,i=0,j=0;

        while(i<nums.length){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()>k){
                map.put(nums[j],map.get(nums[j])-1);
                if(map.get(nums[j])==0)map.remove(nums[j]);
                j++;
            }
            count+=i-j+1;
            i++;
        }
        return count;

    }
}