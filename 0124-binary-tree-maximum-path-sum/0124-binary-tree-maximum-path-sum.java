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
    public int maxPathSum(TreeNode root) {
        int maxi[]=new int[]{Integer.MIN_VALUE};
         maxSum(root,maxi);
         return maxi[0];        
    }
    public int maxSum(TreeNode root , int []maxi){
        if(root==null)return 0;

        int ls = Math.max(0, maxSum(root.left, maxi));
        int rs = Math.max(0, maxSum(root.right, maxi));

        maxi[0]=Math.max(maxi[0], ls+rs+root.val);

        return root.val+Math.max(ls,rs);
    }
}