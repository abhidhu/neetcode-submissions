/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkDepth(root) < 0 ? false : true;
    }
    private int checkDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = checkDepth(root.left);
        int right = checkDepth(root.right);
        return left < 0 || right < 0 || (Math.max(left, right) - Math.min(left, right)) > 1 ? -1 : Math.max(left, right) + 1;
    }
}