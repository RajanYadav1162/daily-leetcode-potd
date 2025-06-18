/*
You are given an integer array nums of size n where n is a multiple of 3 and a positive integer k.

Divide the array nums into n / 3 arrays of size 3 satisfying the following condition:

The difference between any two elements in one array is less than or equal to k.
Return a 2D array containing the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.



Example 1:

Input: nums = [1,3,4,8,7,9,3,5,1], k = 2

Output: [[1,1,3],[3,4,5],[7,8,9]]

Explanation:

The difference between any two elements in each array is less than or equal to 2.

Example 2:

Input: nums = [2,4,2,2,5,2], k = 2

Output: []

Explanation:

Different ways to divide nums into 2 arrays of size 3 are:
 */

class Solution {

  public int[][] divideArray(int[] A, int k) {
    Arrays.sort(A);
    //System.out.println(Arrays.toString(A));
    List<int[]> ans = new ArrayList<>();
    for (int i = 0; i < A.length; i += 3) {
      if (A[i + 2] - A[i] > k) {
        return new int[][]{};
      }
      int j = i;
      int[] t = new int[3];
      while (j < i + 3) {
        t[j - i] = A[j];
        j++;
      }
      ans.add(t);
    }
    return ans.stream().toArray(int[][]::new);
  }
}