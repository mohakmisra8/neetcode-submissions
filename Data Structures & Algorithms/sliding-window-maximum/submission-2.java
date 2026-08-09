class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque();
        int[] res = new int[nums.length - k + 1];
        // check if index is at front of the deque is now outside <= i-k
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // evict from the back while it is smaller
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            if (i >= k-1) {
                res[i-k+1] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
