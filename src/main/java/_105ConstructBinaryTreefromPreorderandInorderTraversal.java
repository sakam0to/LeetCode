import java.util.Arrays;

public class _105ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args){
        _105ConstructBinaryTreefromPreorderandInorderTraversal solution = new _105ConstructBinaryTreefromPreorderandInorderTraversal();
        solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        int index = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }

        if(index > 0){
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                    Arrays.copyOfRange(inorder, 0, index));
        }
        if(index < inorder.length - 1){
            root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                    Arrays.copyOfRange(inorder, index + 1, inorder.length));
        }

        return root;
    }
}
