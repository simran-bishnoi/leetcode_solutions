class Solution {
    public int numberOfSubstrings(String s) {
        long n = s.length();
        long all = n * (n + 1) / 2; // Casts/multiplies in long to prevent overflow
        long ans = SubStr(s);
        return (int) (all - ans);
    }
    public long SubStr(String s){
       int[] freq = new int[26];
int distinct = 0, j = 0,n=s.length();
long ans = 0;

for (int i = 0; i < n; i++) {
    int idx = s.charAt(i) - 'a';
    if (freq[idx]++ == 0) distinct++;

    while (distinct >= 3) {
        int leftIdx = s.charAt(j) - 'a';
        if (--freq[leftIdx] == 0) distinct--;
        j++;
    }
    ans += (i - j + 1);
}
        return ans;
    }
}