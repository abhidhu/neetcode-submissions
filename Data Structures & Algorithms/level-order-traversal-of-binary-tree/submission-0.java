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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<>();
      if(root==null){
        return ans;
      }
      ArrayDeque<TreeNode> dq = new ArrayDeque<>();
      dq.offerLast(root);
      while(!dq.isEmpty()){
        List<Integer> currentLevel = new ArrayList<>();
        int levelSize = dq.size();
        for(int i=0;i<levelSize;i++){
          TreeNode node = dq.pollFirst();
          currentLevel.add(node.val);
          if(node.left!=null){
            dq.offerLast(node.left);
          }
          if(node.right!=null){
            dq.offerLast(node.right);
          }
        }
        ans.add(currentLevel);
      }
      return ans;
    }
}