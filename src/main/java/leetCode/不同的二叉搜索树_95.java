package leetCode;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树_95 {

    List<TreeNode> treeNodes = new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {
        generateTrees2(n-1,new TreeNode(n));
        return treeNodes;
    }

    public void generateTrees2(int n,TreeNode treeNode) {
        if (n == 0) {
            treeNodes.add(treeNode);
            return ;
        }
        TreeNode leftTreeNode = new TreeNode(n,treeNode,null);
        generateTrees2(n-1,leftTreeNode);
        TreeNode rightTreeNode = new TreeNode(n,null,treeNode);
        generateTrees2(n-1,rightTreeNode);
    }

}
