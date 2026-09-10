class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st=new Stack<>();
        boolean des=false;

        for(int i=0; i<asteroids.length; i++){
            while(!st.isEmpty() && asteroids[i]<0 && st.peek()>0){
                if(Math.abs(asteroids[i])<st.peek()){
                 des=true;
                break; 
                }else if(Math.abs(asteroids[i])==st.peek()){
                    st.pop();
                    des=true;
                    break;
                } else st.pop();
               
            }
            if(!des){
            st.push(asteroids[i]);
            
            }
            des=false;
        }
        int ans[]=new int[st.size()];
        while(!st.isEmpty()){
            ans[st.size()-1]=st.pop();
        }
        return ans;
    }
}