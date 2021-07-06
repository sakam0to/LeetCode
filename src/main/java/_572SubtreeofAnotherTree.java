import java.util.*;

public class _572SubtreeofAnotherTree {
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            List<TreeNode> candidates = new LinkedList<>();
            List<TreeNode> allNodes = new LinkedList<>();
            allNodes.add(s);

            while(allNodes.size() > 0){
                TreeNode treenode = allNodes.remove(0);
                if(treenode.val == t.val){
                    candidates.add(treenode);
                }
                if(treenode.left != null){
                    allNodes.add(treenode.left);
                }
                if(treenode.right != null){
                    allNodes.add(treenode.right);
                }
            }
            while(candidates.size() > 0){
                TreeNode treenode = candidates.remove(0);
                if(check(treenode, t)){
                    return true;
                }
            }
            return false;
        }

        private boolean check(TreeNode treenode, TreeNode t) {
            if(null != treenode && null != t){
                if(treenode.val == t.val){
                    if(check(treenode.left, t.left) && check(treenode.right, t.right)){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else if(null != treenode || null != t){
                return false;
            }else{
                return true;
            }
        }
    }
}
