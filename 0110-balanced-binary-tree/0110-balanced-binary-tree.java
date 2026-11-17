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
        return heights(root)!=-1;        
    }
    public int heights(TreeNode root){
        if(root==null)return 0;

        int ls=heights(root.left);
        if(ls<0)return -1;
        int rs=heights(root.right);
        if(rs<0)return -1;

        if(Math.abs(ls-rs)>1)return -1;
        
        return 1+Math.max(ls,rs);

    }
}