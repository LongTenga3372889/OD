package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 */


//[1,2,3,4,5,null,8,null,null,6,7,9]

public class 二叉树的中序遍历_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        return inorderTraversal2(res, root);
    }

    public List<Integer> inorderTraversal2(List<Integer> res, TreeNode root) {
        if (root.left != null) {
            inorderTraversal2(res, root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            inorderTraversal2(res, root.right);
            res.add(root.right.val);
        }
        return res;
    }

}