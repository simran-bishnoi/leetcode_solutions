class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0]==10 || bills[0]==20)return false;
        int five=0,ten=0,twen=0;

        for(int num:bills){
            if(num==5)five++;
            else if(num == 10){
                if(five<1)return false;
                ten++;
                five--;
            }else{
                if((ten<1 && five<3) || five<1)return false;
                twen++;
                if(ten>0){
                    ten--;
                    five--;
                }else five-=3;
            }
        }
        return true;
    }
}