class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<>(Collections.nCopies(n, 0));

            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();

                int index = leftToRight ? i : (n - 1 - i);
                level.set(index, curr.val);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            ans.add(level);
            leftToRight = !leftToRight;
        }

        return ans;
    }
}