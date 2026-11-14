impl Solution {
    pub fn sum_of_digits(nums: Vec<i32>) -> i32 {
        let mut n = *nums.iter().min().unwrap();
        let mut total = 0;
        while n > 0 {
            total += n%10;
            n /= 10;
        }
        1-total%2

    }
}
