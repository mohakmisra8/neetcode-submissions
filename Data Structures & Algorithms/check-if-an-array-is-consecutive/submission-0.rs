impl Solution {
    pub fn is_consecutive(nums: Vec<i32>) -> bool {
        let mut seen = std::collections::HashSet::new();
        let (mut low, mut high) = (nums[0], nums[0]);

        for &x in &nums {
            if !seen.insert(x) {
                return false
            }
            low = low.min(x);
            high = high.max(x);
        }

        (high-low+1) as usize == nums.len()

    }
}
