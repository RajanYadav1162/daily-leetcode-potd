/*
You are given an integer num. You know that Bob will sneakily remap one of the 10 possible digits (0 to 9) to another digit.

Return the difference between the maximum and minimum values Bob can make by remapping exactly one digit in num.

Notes:

When Bob remaps a digit d1 to another digit d2, Bob replaces all occurrences of d1 in num with d2.
Bob can remap a digit to itself, in which case num does not change.
Bob can remap different digits for obtaining minimum and maximum values respectively.
The resulting number after remapping can contain leading zeroes.


Example 1:

Input: num = 11891
Output: 99009
Explanation:
To achieve the maximum value, Bob can remap the digit 1 to the digit 9 to yield 99899.
To achieve the minimum value, Bob can remap the digit 1 to the digit 0, yielding 890.
The difference between these two numbers is 99009.
 */


class Solution {

  public int minMaxDifference(int num) {

    String s = num + "";
    String min = s.replaceAll(s.charAt(0) + "", "0");
    int mx = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '9') {
        mx = i;
        break;
      }
    }

    String max = s.replace(s.charAt(mx) + "", "9");

    return Integer.parseInt(max) - Integer.parseInt(min);
  }
}