class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        int count=0;
        int last =Integer.MIN_VALUE;
        for(int i=0; i<intervals.length; i++){
            if(last>intervals[i][0])count++;
            else last=intervals[i][1];
        }
        return count;
    }
}