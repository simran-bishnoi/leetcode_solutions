class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        for (char ch : t.toCharArray()) {
            hash[ch]++;
        }
        
        int i = 0, j = 0, minlen = Integer.MAX_VALUE, st = 0, cnt = 0;
        int required = t.length();

        while (i < s.length()) {
            char ch = s.charAt(i);
            if (hash[ch] > 0) cnt++;
            hash[ch]--;

            // When all required characters (including duplicates) are matched
            while (cnt == required) {
                if (i - j + 1 < minlen) {
                    minlen = i - j + 1;
                    st = j;
                }
                
                char leftChar = s.charAt(j);
                hash[leftChar]++;
                // If hash becomes > 0, it means we dropped a required character/duplicate count
                if (hash[leftChar] > 0) cnt--;
                j++;
            }
            i++;
        }
        
        return minlen == Integer.MAX_VALUE ? "" : s.substring(st, st + minlen);
    }
}