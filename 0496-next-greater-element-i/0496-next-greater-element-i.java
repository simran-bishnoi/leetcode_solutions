class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>map=new HashMap<>();
        Stack<Integer>st=new Stack<>();

        for(int i=0; i<nums2.length; i++){
            map.put(nums2[i],i);
        }
        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i]))nums1[i]=map.get(nums1[i]);
        }

        st.push(nums2[nums2.length-1]);
        nums2[nums2.length-1]=-1;

        for(int i=nums2.length-2; i>=0; i--){
            int val=nums2[i];
            if(nums2[i]<st.peek())nums2[i]=st.peek();
            else{
                while(!st.isEmpty() && nums2[i]>st.peek()){
                    st.pop();
                }
                if(st.isEmpty())nums2[i]=-1;
                else nums2[i]=st.peek();
            }
            st.push(val);
        }

        for(int i=0; i<nums1.length; i++){
            nums1[i]=nums2[nums1[i]];
        }

        return nums1;
    }
}