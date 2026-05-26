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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        ArrayDeque<TreeNode> dq= new ArrayDeque<>();
        dq.offerLast(root);
        while(!dq.isEmpty()){
            int currentLevelSize = dq.size();
            TreeNode node = null;
            for(int i=0;i<currentLevelSize;i++){
                node = dq.pollFirst();
                if(node.left!=null){
                    dq.offerLast(node.left);
                }
                if(node.right != null){
                    dq.offerLast(node.right);
                }
            }
            ans.add(node.val);//node will never be null as loop will get executed only if dq has atleast 1 value
        }
        return ans;
    }
}