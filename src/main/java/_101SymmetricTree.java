import java.util.LinkedList;
import java.util.Queue;

public class _101SymmetricTree {

    public static void main(String[] args){
        _101SymmetricTree solution = new _101SymmetricTree();
        TreeNode l3 = new TreeNode(3);
        TreeNode r3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode r4 = new TreeNode(4);
        TreeNode l2 = new TreeNode(2);
        TreeNode r2 = new TreeNode(2);
        TreeNode root = new TreeNode(1);

        //l2.left = l3;
        //l2.right = l4;
        //r2.left = r4;
        //r2.right = r3;
        //root.left = l2;
        //root.right = r2;

        System.out.println(solution.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();

        //initialize
        if(null != root){
            if(null != root.left){
                leftQueue.add(root.left);
            }
            if(null != root.right){
                rightQueue.add(root.right);
            }
        }

        //loop
        while(!leftQueue.isEmpty()){
            if(!rightQueue.isEmpty()){
                TreeNode leftNode = leftQueue.poll();
                TreeNode rightNode = rightQueue.poll();
                if(leftNode.val == rightNode.val){
                    if(null != leftNode.left){
                        if(null != rightNode.right){
                            leftQueue.add(leftNode.left);
                            rightQueue.add(rightNode.right);
                        }else{
                            return false;
                        }
                    }else if(null != rightNode.right){
                        return false;
                    }


                    if(null != leftNode.right){
                        if(null != rightNode.left){
                            leftQueue.add(leftNode.right);
                            rightQueue.add(rightNode.left);
                        }else{
                            return false;
                        }
                    }else if(null != rightNode.left){
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }

        //Validate and exit
        if(leftQueue.isEmpty() && rightQueue.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}

