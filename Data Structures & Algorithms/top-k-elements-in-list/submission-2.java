class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i: nums) {
            map.merge(i, 1, Integer::sum);
        }

        return map.entrySet()
            .stream()
            .sorted((a,b) -> b.getValue()- a.getValue())
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
        
    }
}
