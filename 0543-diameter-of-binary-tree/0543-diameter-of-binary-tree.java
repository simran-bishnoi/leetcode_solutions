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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;

        int d1=diameterOfBinaryTree(root.left);
        int d2=diameterOfBinaryTree(root.right);

        int h1=ht(root.left);
        int h2=ht(root.right);

        int d=h1+h2+2;

        return Math.max(d,Math.max(d1,d2));
    }
    public int ht(TreeNode root){
        if(root==null)return -1;

        int ls=ht(root.left);
        int rs=ht(root.right);

        return Math.max(ls,rs)+1;
    }
}