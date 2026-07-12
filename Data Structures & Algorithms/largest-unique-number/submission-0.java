class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Long> freq = Arrays.stream(nums)
                                    .boxed()
                                    .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        
        return freq.entrySet().stream()
                    .filter(e -> e.getValue() == 1)
                    .mapToInt(Map.Entry:: getKey)
                    .max()
                    .orElse(-1);
        
    }
}
