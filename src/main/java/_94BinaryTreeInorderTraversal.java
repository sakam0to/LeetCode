import java.util.*;

public class _94BinaryTreeInorderTraversal {

    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        solution.inorderTraversal(node);
    }

    static class Solution {
        List<Integer> result = new LinkedList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();

            if(root != null){
                visit(root);
            }

            return result;
        }

        private void visit(TreeNode node){
            if(node.left != null){
                visit(node.left);
            }

            result.add(node.val);

            if(node.right != null){
                visit(node.right);
            }
        }
    }
}
