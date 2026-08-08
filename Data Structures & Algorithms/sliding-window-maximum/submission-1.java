class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // check if index at the front of the deque is now outside the window <= i-k
            if (!d.isEmpty() && d.peekFirst() <= i - k) {
                d.pollFirst();
            }

            // evict from the back while it is smaller
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i]) {
                d.pollLast();
            }
            d.addLast(i);

            // record the max
            if (i >= k - 1) {
                res[i -k +1] = nums[d.peekFirst()];
            }
        }
        return res;
    }
}
