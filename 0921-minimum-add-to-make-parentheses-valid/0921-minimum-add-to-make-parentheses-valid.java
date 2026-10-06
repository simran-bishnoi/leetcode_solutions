class Solution {
    public int minAddToMakeValid(String s) {
        int move=0,open=0;

        for(char ch:s.toCharArray()){
            if(ch=='(')open++;
            else{
                if(open>0)open--;
                else move++;
            }
        }
        return move+open;
    }
}