package strive.insist.xiaoaxiao.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiaoaxiao on 2019/12/16
 * Description: 二叉树的右视图
 *      层序遍历的思想：
 *          每层的结点遍历前记录当前队列中的元素(该层元素个数)，
 *          将该层的所有结点的左右子树在for循环中进行入队操作(一次性将整层的值的左右子树都进行入队操作)
 *          若for循环中的i==size-1，说明当前节点就是这一层的最右节点。
 *          同理，i==1时就是最左节点，都不需要这样判断，每次的队首节点就是最左节点，每次循环将整层全部入队
 *      设置标志记号的思想：
 *          记录一个level，使用根右左的遍历方式。
 *              若level与最终链表的长度相同，说明该节点是最右节点需要被加入
 *              若不同，说明该层已经有最右节点被加入了
 *          注意在找其左右节点时，level需要+1
 *          同理：以根左右的遍历方式得到的就是左视图
 *
 */
public class leetcode199 {
    /**
     * 层序遍历变种
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size-1){
                    ret.add(node.val);
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return ret;
    }

    /**
     * 设置标志level与最终返回列表size()的关系
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        getRight(ret,root,0);
        return ret;
    }
    private void getRight(List<Integer> ret,TreeNode root,int level){
        if (root == null){
            return ;
        }

        if (ret.size()==level){
            ret.add(root.val);
        }
        getRight(ret,root.right,level+1);
        getRight(ret,root.left,level+1);
    }
}
