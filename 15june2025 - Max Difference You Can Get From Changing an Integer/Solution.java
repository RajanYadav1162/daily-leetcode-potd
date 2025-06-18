/*
You are given an integer num. You will apply the following steps to num two separate times:

Pick a digit x (0 <= x <= 9).
Pick another digit y (0 <= y <= 9). Note y can be equal to x.
Replace all the occurrences of x in the decimal representation of num by y.
Let a and b be the two results from applying the operation to num independently.

Return the max difference between a and b.

Note that neither a nor b may have any leading zeros, and must not be 0.



Example 1:

Input: num = 555
Output: 888
Explanation: The first time pick x = 5 and y = 9 and store the new integer in a.
The second time pick x = 5 and y = 1 and store the new integer in b.
We have now a = 999 and b = 111 and max difference = 888
 */

class Solution {

  public int maxDiff(int num) {
    String s = num + "";

    String max = s;
    for (int k = 0; k < s.length(); k++) {
      if (s.charAt(k) != '9') {
        max = s.replaceAll(s.charAt(k) + "", "9");
        break;
      }
    }

    int i = 0;
    while (i < s.length() && s.charAt(i) == '1') {
      i++;
    }
    String min = s;

    if (i == 0) {
      min = s.replaceAll(s.charAt(i) + "", "1");
    } else if (i < s.length()) {
      while (i < s.length() && (s.charAt(i) == '0' || s.charAt(0) == s.charAt(i))) {
        i++;
      }
      if (i < s.length()) {
        min = s.replaceAll(s.charAt(i) + "", "0");
      }
    }

    return Integer.parseInt(max) - Integer.parseInt(min);
  }
}