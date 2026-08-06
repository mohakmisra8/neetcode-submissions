class Solution {
    public int findDuplicate(int[] nums) {
        // pointers are indices  where you jump to next
        // value at the edges is what connects them
        // re anchor the array as a linked list
        // cycle when two different indices return the same value
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow]; // one jump
            fast = nums[nums[fast]]; // two jump
        }

        slow = 0; // reset 1 pointer back to start
        while (slow != fast) {
            slow = nums[slow]; // both move one jump at a time
            fast = nums[fast];
        }

        return slow; // meet at entrance = duplicate

        
    }
}
