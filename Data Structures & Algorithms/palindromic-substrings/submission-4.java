class Solution {
    public int countSubstrings(String s) {
        // iterate over length n
        // if it is oddd length n the number of centres will be n
        // if it is even then it will be n-1 centres
        // total number of centres will be 2n-1 
        // we need to have left and right pointer starting over i and i +1 and then append count to return it
        int count = 0;
        for(int i = 0; i<s.length(); i++) {
            count += expand(s, i, i);
            count += expand(s, i, i+1);
        }
        return count;
        
    }

    private int expand(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}
