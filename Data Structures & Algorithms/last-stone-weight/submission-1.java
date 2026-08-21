class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (int s : stones) {
            heap.add(s);
        }

        while (heap.size() > 1) {
            int firstHeavy = heap.remove();
            int secondHeavy = heap.remove();

            if (firstHeavy != secondHeavy) {
                heap.add(firstHeavy - secondHeavy);
            }
        }

        if(heap.isEmpty()) {
            return 0;
        }

        return heap.peek();
    }
}
