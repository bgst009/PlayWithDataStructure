/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName LinkedList.java
 * @createTime 2020年05月25日 07:41:00
 */
public class LinkedList<E> {

    /**
     * 链表的底层结构，对用户隐藏
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e.toString() +
                    '}';
        }
    }

    /**
     * 链表头
     */
    private Node head;
    /**
     * 链表中有多少个元素
     */
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 获取列表中的元素个数
     *
     * @return int 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 看链表是否为空
     *
     * @return boolean 空则返回 true
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加新的元素
     *
     * @param e 要添加的元素
     */
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next=head;
//        head=node;

        head = new Node(e, this.head);
        size++;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     *
     * @param index 位置
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            prev.next = new Node(e, prev.next);

            size++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }
}
