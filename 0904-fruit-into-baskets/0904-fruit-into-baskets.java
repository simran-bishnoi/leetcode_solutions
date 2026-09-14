class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length<=2)return fruits.length;
        int i=0,j=0,len=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        while(i<fruits.length){
            map.put(fruits[i],map.getOrDefault(fruits[i],0)+1);
            
            if(map.size()>2){
                map.put(fruits[j],map.get(fruits[j])-1);
                if (map.get(fruits[j]) == 0) {
                    map.remove(fruits[j]);
             }
                j++;
            }
            len=Math.max(len,i-j+1);
            i++;
        }
        return len;
    }
}