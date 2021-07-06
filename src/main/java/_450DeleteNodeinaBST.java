public class _450DeleteNodeinaBST {
    public static void main(String[] args){
        _450DeleteNodeinaBST solution = new _450DeleteNodeinaBST();
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3, two, four);
        TreeNode seven = new TreeNode(7);
        TreeNode six = new TreeNode(6, seven, null);
        TreeNode five = new TreeNode(5, three, six);
        TreeNode ans = solution.deleteNode(five, 3);
        System.out.println(ans.val);
    }

    TreeNode parent;
    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode found = find(root, key);

        if(found != null){
            if(found == root){
                return replaceByNext(found);
            }
            replaceByNext(found);
        }

        return root;
    }

    private TreeNode find(TreeNode root, int key){
        if(root == null)
            return null;

        if(root.val == key)
            return root;
        else if(root.val < key){
            parent = root;
            return find(root.right, key);
        }
        else{
            parent = root;
            return find(root.left, key);
        }
    }

    private TreeNode replaceByNext(TreeNode node){
        //case 1: leaves
        if(node.left == null && node.right == null){
            if(parent == null)
                return null;
            else if(parent.left != null && parent.left.val == node.val)
                parent.left = null;
            else
                parent.right = null;
            return null;
        } else{ //case 2: intermediate nodes
            TreeNode next = findPrecursor(node);
            if(next == null){
                next = findSuccessor(node);
            }

            node.val = next.val;
            replaceByNext(next);
            return node;
        }
    }

    private TreeNode findPrecursor(TreeNode node){
        if(node.left != null){
            parent = node;
            node = node.left;
            while(node.right != null){
                parent = node;
                node = node.right;
            }
            return node;
        } else
            return null;
    }

    private TreeNode findSuccessor(TreeNode node){
        if(node.right != null){
            parent = node;
            node = node.right;
            while(node.left != null){
                parent = node;
                node = node.left;
            }
            return node;
        } else
            return null;
    }
}
