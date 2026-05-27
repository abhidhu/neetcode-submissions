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
    int preIndex=0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0){
            return null;        
        }   
        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return getNode(preorder, inorder, 0, preorder.length-1);     
    }
    private TreeNode getNode(int[] pre, int[] in, int left, int right) {
        if (left > right) return null;  // Base case

        TreeNode root = new TreeNode(pre[preIndex++]);
        int mid = findInArray(root.val);

        root.left = getNode(pre, in, left, mid - 1);
        root.right = getNode(pre, in, mid + 1, right);

        return root;
    }
    private int findInArray(int val){
        return map.get(val);
    }
}