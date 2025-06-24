/*
3085. Minimum Deletions to Make String K-Special
You are given a string word and an integer k.

We consider word to be k-special if |freq(word[i]) - freq(word[j])| <= k for all indices i and j in the string.

Here, freq(x) denotes the frequency of the character x in word, and |y| denotes the absolute value of y.

Return the minimum number of characters you need to delete to make word k-special.

Example 1:

Input: word = "aabcaba", k = 0

Output: 3

Explanation: We can make word 0-special by deleting 2 occurrences of "a" and 1 occurrence of "c". Therefore, word becomes equal to "baba" where freq('a') == freq('b') == 2.

Example 2:

Input: word = "dabdcbdcdcd", k = 2

Output: 2

Explanation: We can make word 2-special by deleting 1 occurrence of "a" and 1 occurrence of "d". Therefore, word becomes equal to "bdcbdcdcd" where freq('b') == 2, freq('c') == 3, and freq('d') == 4.
 */

/*
there are two approaches to solve this problem binary counting + search + prefix and counting + hashmap
main idea is to keep one item as minimum and construct answer based on this minimum.
 */


class Solution {

  public int minimumDeletions(String word, int k) {

    int[] freq = new int[26];
    int n = 0;
    for (char ch : word.toCharArray()) {
      if (freq[ch - 'a'] == 0) {
        n++;
      }
      freq[ch - 'a']++;
    }

    int[] arr = new int[n];
    int m = 0;
    for (int f : freq) {
      if (f != 0) {
        arr[m++] = f;
      }
    }
    Arrays.sort(arr);
    //  System.out.println(Arrays.toString(arr));
    int[] prefix = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      prefix[i] = prefix[i - 1] + arr[i - 1];
    }
    int ans = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      int higher = find(arr, i + 1, arr[i] + k + 1);
      int lower = find(arr, 0, arr[i]);

      int ls = prefix[lower];
      int rs = higher == n ? 0 : prefix[n] - prefix[higher];

//      System.out.println(
//          "for i " + i + " higher " + higher + "  " + "lower " + lower + " rs and ls " + rs + "  "
//              + ls);

      ans = Math.min(ans, ls + Math.abs(rs - ((n - higher) * (arr[i] + k))));
    }

    return ans;
  }

  public int find(int[] arr, int left, int target) {
    int right = arr.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}