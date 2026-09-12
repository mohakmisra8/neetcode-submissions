class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int boat = 0;
        while(left <= right) {
            int remaining = limit - people[right--];
            boat++;
            if(left <= right && remaining >= people[left]) {
                left++;
            }
        }
        return boat;
    }
}