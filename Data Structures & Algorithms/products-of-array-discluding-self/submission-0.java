class Solution {
    public int[] productExceptSelf(int[] nums) {
        // prefix product
        final var len = nums.length;
        final var res = new int[nums.length];

        for(int i = 0;i<nums.length;i++){
            var prod = 1;
            for(int j = 0;j<len;j++){
                if(i!=j){
                    prod *= nums[j];
                }
            }
            res[i] = prod;
        }
        return res;

        
    }

}  
