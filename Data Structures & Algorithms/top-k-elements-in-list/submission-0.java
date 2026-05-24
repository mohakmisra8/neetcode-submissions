class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final var res = new int[k];
        final var map = new HashMap<Integer, Integer>();
        for(var n: nums) {
            map.merge(n, 1, Integer::sum);
        }

        return map.entrySet()
            .stream()
            .sorted((a,b) -> b.getValue() - a.getValue())
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }
}
