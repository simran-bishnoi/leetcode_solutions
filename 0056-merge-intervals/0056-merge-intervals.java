import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 1. Sort intervals based on their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        
        // 2. Track the current interval being merged
        int[] currentInterval = intervals[0];
        ans.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            // If they overlap, merge them by updating the end time
            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, move to the next interval
                currentInterval = intervals[i];
                ans.add(currentInterval);
            }
        }

        // 3. Convert the List back to a 2D array and return
        return ans.toArray(new int[ans.size()][]);
    }
}