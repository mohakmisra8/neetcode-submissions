class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for(int[] p: points) {
            int distance = p[0]*p[0] + p[1]*p[1];
            minHeap.offer(new int[]{distance, p[0], p[1]});
        }

        int[][] res = new int[k][2];
        for(int i = 0; i<k;i++) {
            int[] p = minHeap.poll();
            res[i] = new int[]{p[1], p[2]};
        }

        return res;
        

    }
}
