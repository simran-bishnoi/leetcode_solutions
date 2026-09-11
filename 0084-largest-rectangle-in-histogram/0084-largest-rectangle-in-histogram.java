class Solution {
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        if(n==1)return heights[0];
        int nse[]=nseFind(heights);
        int pse[]=pseFind(heights);
        int ans=0;
        for(int i=0; i<n; i++){
            
            int val=nse[i] - pse[i] - 1;

            ans=Math.max(ans, (val*heights[i]));
        }
        return ans;
    }
    public int[] nseFind(int[] arr){
        int n=arr.length;
        int nse[]=new int[n];
        Stack<Integer>st=new Stack<>();

        for(int i=n-1; i>=0; i--){

            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] pseFind(int[] arr){
        int n=arr.length;
        int pse[]=new int[n];
        Stack<Integer>st=new Stack<>();

        for(int i=0; i<n; i++){

            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
}