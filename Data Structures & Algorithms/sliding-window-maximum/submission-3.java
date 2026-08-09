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

        // Each index is added exactly once (one addLast per iteration → n insertions total). And since something can only be removed if it was first inserted, there are at most n removals total across the whole run.

// So even though the inner while might pop several elements in a single iteration, those pops are "paid for" by insertions that already happened. Summed over all iterations, the inner loop can execute at most n times in total — not n times per outer iteration.

// That's the amortized argument: outer loop does n iterations, and all inner-loop work across the entire run sums to ≤ n. Total O(n) + O(n) = O(n) time. Space is O(k) — the deque holds at most one window's worth of indices.

// each element is pushed and popped at most once, so the total inner-loop work is bounded by n regardless of how it clusters."

        return res;
    }
}
