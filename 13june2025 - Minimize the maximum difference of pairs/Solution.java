/*
You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the p pairs.

Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.

Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.



Example 1:

Input: nums = [10,1,2,7,1,3], p = 2
Output: 1
Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices 2 and 5.
The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.
 */

class Solution {

  public int minimizeMax(int[] nums, int p) {
    if (p == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int left = 0, right = 0, n = nums.length;

    int min = Arrays.stream(nums).min().getAsInt();
    int max = Arrays.stream(nums).max().getAsInt();

    right = max - min;

    while (left < right) {
      int mid = left + (right - left) / 2;
      int count = 0;
      for (int i = 1; i < n; i++) {
        if (nums[i] - nums[i - 1] <= mid) {
          count++;
          i++;
        }
        if (count == p) {
          break;
        }
      }
      if (count == p) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }
}