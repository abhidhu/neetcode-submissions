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
    public int goodNodes(TreeNode root) {
        return countGood(Integer.MIN_VALUE, root);
    }
    private int countGood(int max, TreeNode node){
        if(node==null){
            return 0;
        }
        int temp = node.val >= max ? 1 : 0;
        temp+=countGood(Math.max(max, node.val), node.left);
        temp+=countGood(Math.max(max, node.val), node.right);
        return temp;
    }
}