impl Solution {
    pub fn has_duplicate(nums: Vec<i32>) -> bool {
        let mut seen = HashSet::new();

        for i in nums {
            if !seen.insert(i) {
                return true;
            }
        }

        return false;

    }
}
