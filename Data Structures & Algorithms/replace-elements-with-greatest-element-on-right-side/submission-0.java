class Solution {
    public int[] replaceElements(int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i< arr.length;i++){
            int right = -1;
            for (int j = i+1;j<arr.length;j++) {
                right = Math.max(right, arr[j]);
            }
            newArr[i] = right;
        }
        return newArr;
        
    }
}