class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a:nums) {
            map.merge(a,1,Integer::sum);
        }

        return map.entrySet()
            .stream()
            .sorted((a,b) -> b.getValue() - a.getValue())
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
        
    }
}
