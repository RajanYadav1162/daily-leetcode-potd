/*
Given a binary tree with the following rules:

root.val == 0
For any treeNode:
If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

Implement the FindElements class:

FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it.
bool find(int target) Returns true if the target value exists in the recovered binary tree.


Example 1:


Input
["FindElements","find","find"]
[[[-1,null,-1]],[1],[2]]
Output
[null,false,true]
Explanation
FindElements findElements = new FindElements([-1,null,-1]);
findElements.find(1); // return False
findElements.find(2); // return True
Example 2:


Input
["FindElements","find","find","find"]
[[[-1,-1,-1,-1,-1]],[1],[3],[5]]
Output
[null,true,true,false]
Explanation
FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
findElements.find(1); // return True
findElements.find(3); // return True
findElements.find(5); // return False
 */


//my initial solution
//idea is according to question mark -1 ele with respective value based on left or right.
class FindElements {

  Set<Integer> set = new HashSet<>();

  public FindElements(TreeNode root) {
    capture(root, null, null);
    //  System.out.println(set);
  }

  public void capture(TreeNode root, TreeNode left, TreeNode right) {
    if (root == null) {
      return;
    }

    if (left == null && right == null) {
      set.add(0);
      root.val = 0;
      capture(root.left, root, null);
      capture(root.right, null, root);
    } else if (left == null) {
      int x = (2 * right.val + 2);
      root.val = x;
      set.add(x);
      capture(root.left, root, null);
      capture(root.right, null, root);
    } else if (right == null) {
      int x = (2 * left.val + 1);
      root.val = x;
      set.add(x);
      capture(root.left, root, null);
      capture(root.right, null, root);
    }
  }

  public boolean find(int target) {
    return set.contains(target);
  }
}


//more intuitive solution

class FindElements {
  Set<Integer> set = new HashSet<>();
  public FindElements(TreeNode root) {
    capture(root, 0);
    //  System.out.println(set);
  }

  public void capture(TreeNode root, int val){

    if(root == null) return;
    set.add(val);
    capture(root.left, val * 2 + 1);
    capture(root.right, val * 2 + 2);
  }

  public boolean find(int target) {
    return set.contains(target);
  }
}

