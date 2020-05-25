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
    private Node dummyHead;
    /**
     * 链表中有多少个元素
     */
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
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
     * 在链表的index(0-based)位置添加新的元素e
     *
     * @param index 位置
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(e, prev.next);
        size++;
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

        add(0, e);
    }

    /**
     * 在链表末尾添加新的元素e
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表的第index(0-based)个位置的元素
     *
     * @param index index
     * @return index 位置的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     *
     * @return 第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     *
     * @return 最后一个元素
     */
    public E getLast() {
        return get(size);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e
     *
     * @param index 所修改元素的内容的索引
     * @param e     元素值
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed,Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     *
     * @param e 元素
     * @return true 存在
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * @return 链表中的元素
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(Node cur = dummyHead.next ; cur != null ; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
