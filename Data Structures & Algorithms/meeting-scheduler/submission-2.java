class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        for(int[] s:slots1) {
            if(s[1]-s[0] >= duration) {
                q.offer(new int[] {s[0], s[1], 1});
            }
        }
        
        for(int[] s:slots2) {
            if(s[1]-s[0] >= duration) {
                q.offer(new int[] {s[0], s[1], 2});
            }
        }

        while(q.size() > 1) {
            int[] slot1 = q.poll();
            int[] slot2 = q.peek();

            if(slot1[2] != slot2[2]) {
                int start = slot1[0] > slot2[0] ? slot1[0] : slot2[0];
                int end = slot1[1] < slot2[1] ? slot1[1] : slot2[1];
                if(end-start >= duration) {
                    return Arrays.asList(start, start+duration);
                }
            }

        }
        return new ArrayList<>();
    }
}
