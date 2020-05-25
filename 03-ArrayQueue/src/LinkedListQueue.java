/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName LinkedListQueue.java
 * @createTime 2020年05月25日 11:21:00
 */
public class LinkedListQueue<E> implements Queue<E> {
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Dequeue Error, Can Not Remove Element from empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;

        if (head == null) {
            tail = null;
        }

        size--;

        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("getFront Error, Can Not getFront Element from empty queue");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: Front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append(" NULL tail");
        return res.toString();
    }

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
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> integerLinkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            integerLinkedListQueue.enqueue(i);
            System.out.println(integerLinkedListQueue);

            if (i % 3 == 2) {
                integerLinkedListQueue.dequeue();
                System.out.println(integerLinkedListQueue);
            }
        }
    }
}
