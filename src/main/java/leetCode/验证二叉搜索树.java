package leetCode;

/**
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class 验证二叉搜索树 {

    static Boolean checkFlag = true;

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(-2147483648);
        TreeNode treeNode7 = new TreeNode(2147483647);
        treeNode3.right = treeNode7;
        验证二叉搜索树 a = new 验证二叉搜索树();
        System.out.println(a.isValidBST(treeNode3));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST2(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    public boolean isValidBST2(TreeNode root,long max,long min) {
        if (!checkFlag) {
            return false;
        }
        if (root.left != null) {
            checkFlag = root.left.val>min  && root.left.val<max && root.val>root.left.val;
            if (checkFlag) {
                checkFlag = isValidBST2(root.left, root.val, min);
            }
        }
        if (root.right != null && checkFlag) {
            checkFlag = root.right.val>min && root.right.val<max && root.val<root.right.val;
            if (checkFlag) {
                checkFlag = isValidBST2(root.right, max, root.val);
            }
        }
        return checkFlag;
    }

}
