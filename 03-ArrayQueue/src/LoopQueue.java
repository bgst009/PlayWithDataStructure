/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName LoopQueue.java
 * @createTime 2020年05月24日 14:36:00
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    @Override
    public void enqueue(E e) throws IllegalAccessException {

    }

    @Override
    public E dequeue() throws IllegalAccessException {
        return null;
    }

    @Override
    public E getFront() throws IllegalAccessException {
        return null;
    }
}
