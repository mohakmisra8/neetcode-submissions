class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int n = arr.length;
        int r = n-1;

        while(r-l >= k) {
            if(Math.abs(x-arr[l]) <= Math.abs(x-arr[r])) {
                r--;
            } else {
                l++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i =l; i<=r;i++) {
            result.add(arr[i]);
        }
        return result;
    }
}