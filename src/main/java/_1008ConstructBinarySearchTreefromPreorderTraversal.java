import java.util.Arrays;

public class _1008ConstructBinarySearchTreefromPreorderTraversal {
    public static void main(String[] args){
        _1008ConstructBinarySearchTreefromPreorderTraversal solution = new _1008ConstructBinarySearchTreefromPreorderTraversal();
        solution.bstFromPreorder(new int[]{8,5,1,7,10,12});
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        int left = 1;
        while(left < preorder.length){
            if(preorder[left] > preorder[0]){
                root.right = bstFromPreorder(Arrays.copyOfRange(preorder, left, preorder.length));
                break;
            }
            left++;
        }
        if(left > 1){
            root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, left));
        }
        return root;
    }
}
