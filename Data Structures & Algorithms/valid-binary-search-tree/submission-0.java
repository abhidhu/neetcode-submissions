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
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return isValidLeftAndRight(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidLeftAndRight(TreeNode node, long left, long right){
        if(node == null){
            return true;//break if null
        }
        if(node.val<=left || node.val >= right){
            return false;
        }
        return isValidLeftAndRight(node.left, left, node.val) && isValidLeftAndRight(node.right, node.val, right);
    }
}