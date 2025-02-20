/*

Given an array of strings nums containing n unique binary strings each of length n,
return a binary string of length n that does not appear in nums.
If there are multiple answers, you may return any of them.

Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
 */

//verbose solution
class Solution {

  Set<String> set = new HashSet<>();
  int n;
  String ans = "";

  public String findDifferentBinaryString(String[] nums) {
    this.n = nums[0].length();
    for (var a : nums) {
      set.add(a);
    }
    helper("");
    return ans;
  }

  public void helper(String psf) {

    Queue<String> queue = new LinkedList<>();
    queue.offer("0");
    queue.offer("1");

    while (queue.size() != 0) {
      for (int i = 0; i < queue.size(); i++) {
        String s = queue.poll();
        if (s.length() == n && !set.contains(s)) {
          ans = s;
          return;
        }
        if (s.length() != n) {
          queue.offer(s + "0");
          queue.offer(s + "1");
        }
      }
    }
  }
}


class Solution2 {

  public String findDifferentBinaryString(String[] nums) {

    //[01, 10] --> [0][0] == 0 append 1 in answer, basically unique string will be generated.
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      ans.append(nums[i].charAt(i) == '0' ? 1 : 0);
    }
    return ans.toString();
  }

}
//intuitive
