package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 恢复二叉搜索树_99 {

    Map<TreeNode,String> res = new HashMap<>();

    public void recoverTree(TreeNode root) {
        inorderTraversal(root, Long.MAX_VALUE, Long.MIN_VALUE);
        List<TreeNode> list = new ArrayList<>(res.keySet());
        TreeNode node1 = list.get(0);
        TreeNode node2 = list.get(1);
        if (res.get(node1).equals("left")) {
            if (res.get(node2).equals("right")) {
                TreeNode left = node1.left;
                TreeNode node1Right = left.right;
                TreeNode node1left = left.left;
                TreeNode right = node2.right;
                TreeNode node2Right = right.right;

                left.left = right.left;
                left.right = node2Right;
                right.left = node1left;
                right.right = node1Right;
                node1.left = right;
                node2.right = left;
            }else {
                TreeNode left = node1.left;
                TreeNode node1Right = left.right;
                TreeNode node1left = left.left;


                TreeNode right = node2.left;
                TreeNode node2Right = right.right;

                left.left = node2Right;
                left.right = node2.left;
                right.left = node1left;
                right.right = node1Right;

                node1.left = left;
                node2.right = right;
            }
        } else {

        }
    }

    public void inorderTraversal(TreeNode root,long max,long min)
    {
        if(res.size()==2 || root==null) {
            return ;
        }
        if (root.left!=null) {
            if (root.left.val<root.val && root.left.val<max && root.left.val>min) {
                inorderTraversal(root.left,root.val,min);
            } else {
                res.put(root,"left");
                inorderTraversal(root.left,max,min);
            }
        }
        if (root.right!=null) {
            if (root.right.val>root.val && root.right.val>min && root.right.val<max) {
                inorderTraversal(root.right,max,root.val);
            } else {
                res.put(root,"right");
                inorderTraversal(root.right,max,min);
            }
        }
    }

}
