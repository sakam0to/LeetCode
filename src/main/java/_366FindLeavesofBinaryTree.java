import java.util.*;

public class _366FindLeavesofBinaryTree {
    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        solution.findLeaves(root);
    }

    static class Solution {

        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> results = new LinkedList<>();
            Set<TreeNode> removal = new HashSet<>();

            while((root.left != null && !removal.contains(root.left)) || (root.right != null && !removal.contains(root.right))){
                LinkedList<TreeNode> queue = new LinkedList<>();
                LinkedList<Integer> result = new LinkedList<>();
                queue.add(root);

                while(queue.size() > 0){
                    TreeNode node = queue.remove();

                    if((node.left != null && !removal.contains(node.left))){
                        queue.add(node.left);
                    }

                    if((node.right != null && !removal.contains(node.right))){
                        queue.add(node.right);
                    }

                    if((node.left == null || removal.contains(node.left)) && (node.right == null ||  removal.contains(node.right))){
                        removal.add(node);
                        result.add(node.val);
                    }
                }
                results.add(result);
            }

            results.add(Arrays.asList(root.val));
            return results;
        }
    }
}
