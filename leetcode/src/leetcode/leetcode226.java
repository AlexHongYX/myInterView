package strive.insist.xiaoaxiao.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaoaxiao on 2020/1/3
 * Description: 翻转二叉树
 *      递归：容易实现
 *      非递归：借助队列
 */
public class leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        return root;
    }
}
