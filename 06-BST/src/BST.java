import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName BST.java
 * @createTime 2020年05月26日 14:45:00
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素e
     *
     * @param e 插入的元素
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     * 返回插入新节点后二分搜索树的根
     *
     * @param node 根节点
     * @param e    插入的元素
     */
    private Node add(Node node, E e) {

        /*
         * 递归到底的情况
         */
        if (node == null) {
            size++;
            return new Node(e);
        }

        /*
         * 宏观处理流程
         */
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * 看二分搜索树中是否包含元素e
     *
     * @param e 被查找的元素
     * @return Boolean true 存在 false 不存在
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e, 递归算法
     *
     * @param node 根
     * @param e    被查找的元素
     * @return Boolean true 存在 false 不存在
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树, 递归算法
     *
     * @param node 根节点
     */
    private void preOrder(Node node) {
        /*
         * 递归终止
         */
        if (node == null) {
            return;
        }
        /*
          递归逻辑
         */
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的非递归前序遍历
     */
    public void preOrderNR() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树, 递归算法
     *
     * @param node 根
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树, 递归算法
     *
     * @param node 根
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     *
     * @return value of Node
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        Node minNode = minimum(root);
        return minNode.e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     *
     * @param node 根节点
     * @return 最小值节点
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     *
     * @return value of Node
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     *
     * @param node 根节点
     * @return 最大值节点
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     *
     * @return 最小值
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node 根节点
     * @return 删除最小值后的根节点
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);

        return node;

    }

    /**
     * 从二分搜索树中删除最大值所在节点
     *
     * @return 最大值
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(this.root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node 根节点
     * @return 删除最大节点后后的根节点
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     *
     * @param e 元素为e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
     *
     * @param node 二分搜索树的根
     * @param e    元素为e
     * @return 删除节点后新的二分搜索树的根
     */
    private Node remove(Node node, E e) {
        //没有找到
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {// e.compareTo(node.e) == 0
            //左子树为空（类似删除最小值）
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //右子树为空（类似删除最大值）
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 左右子树都不为空
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            Node successor = minimum(node.right);
            // 用这个节点顶替待删除节点的位置
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     *
     * @param node  根节点
     * @param depth 深度
     * @param res   树字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }

        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        res.append("--".repeat(Math.max(0, depth)));
        return res.toString();
    }
}
