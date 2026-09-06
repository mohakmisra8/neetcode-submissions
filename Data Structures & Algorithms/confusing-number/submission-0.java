class Solution {
    public boolean confusingNumber(int n) {
        Map<Integer, Integer> sameWhenRotated = Map.of(0, 0, 1, 1, 8, 8, 6, 9, 9, 6);

        StringBuilder sb = new StringBuilder();

        for (char ch : String.valueOf(n).toCharArray()) {
            int digit = ch - '0';
            if (!sameWhenRotated.containsKey(digit)) {
                return false;
            }
            sb.append(sameWhenRotated.get(digit));
        }

        sb.reverse();
        return Integer.parseInt(sb.toString()) != n;
    }
}
