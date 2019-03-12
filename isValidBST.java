/*leetcode 98题：验证二叉搜索树 难度：中*/
/*判断是否为二叉搜索树*/
/*主要思路为判断三种类型的结点*/
/*用中序遍历的方法较为简单，此方法过于繁琐*/
public class SolutionOfIsValidBST {
	public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        boolean x = true;
        boolean y = true;
        if(root.left != null){
            boolean i = true;
            boolean j = true;
            if(root.left.val >= root.val)
                return false;
            if(root.left.left != null)
                i = (root.left.left.val < root.left.val ) && 
                ValidBST(root.left.left, root.left, root);
            if(root.left.right != null)
                j = (root.left.right.val > root.left.val ) &&
                (root.left.right.val < root.val) &&
                ValidBST(root.left.right, root.left, root);
            x = i && j;
        }
        if(root.right != null){
            boolean i = true;
            boolean j = true;
            if(root.right.val <= root.val)
                return false;
            if(root.right.left != null)
                i = (root.right.left.val < root.right.val ) && 
                (root.right.left.val > root.val) &&
                ValidBST(root.right.left, root.right, root);
            if(root.right.right != null)
                j = (root.right.right.val > root.right.val ) &&
                ValidBST(root.right.right, root.right, root);
            y = i && j;
        }
        return x && y;
    }
    
    private boolean ValidBST(TreeNode root, TreeNode cul, TreeNode pre) {
        if(root == null)
            return true;
        if(root.left != null &&
                (root.val <= root.left.val ||
                (root == cul.right && cul.val >= root.left.val) ||
                (root ==cul.left && cul == pre.right && pre.val >= root.left.val)))
            return false;
        if(root.right != null &&
                (root.val >= root.right.val ||
                (root == cul.left && cul.val <= root.right.val) ||
                (root ==cul.right && cul == pre.left && pre.val <= root.right.val)))    
            return false; 
        return ValidBST(root.left, root, cul) &&
        ValidBST(root.right, root, cul);
    }

}
