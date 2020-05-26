import org.w3c.dom.Node;

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
}
