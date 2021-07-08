public class _112PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;

        if(root.left == null && root.right == null){
            if(targetSum == root.val)
                return true;
            else
                return false;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
