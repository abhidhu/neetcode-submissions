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

    Map<Integer, Integer> map = new HashMap<>();
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map.clear();
        this.index = 0;
        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int left, int right){

        if(left > right){ 
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);

        root.left = build(preorder, inorder, left, map.get(root.val)-1);

        root.right = build(preorder, inorder, map.get(root.val)+1, right);

        return root;
    }
}