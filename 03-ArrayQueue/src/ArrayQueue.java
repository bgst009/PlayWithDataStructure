/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName ArrayQueue.java
 * @createTime 2020年05月24日 14:06:00
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * 队列总容量
     *
     * @return int 总容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 队列中元素的个数
     *
     * @return 元素个数 整形
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判读队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 入队
     *
     * @param e 进入队列的元素
     * @throws IllegalAccessException 异常
     */
    @Override
    public void enqueue(E e) throws IllegalAccessException {
        array.addLast(e);
    }

    /**
     * 出队
     *
     * @return 所删除元素
     * @throws IllegalAccessException 异常
     */
    @Override
    public E dequeue() throws IllegalAccessException {
        return array.removeFirst();
    }

    /**
     * 获取队首元素
     *
     * @return 队首元素<E>
     * @throws IllegalAccessException 异常
     */
    @Override
    public E getFront() throws IllegalAccessException {
        return array.getFirst();
    }

    /**
     * 打印队列
     *
     * @return 队列 字符串
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            try {
                res.append(array.get(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            integerArrayQueue.enqueue(i);
            System.out.println(integerArrayQueue);

            if (i % 3 == 2) {
                integerArrayQueue.dequeue();
                System.out.println(integerArrayQueue);
            }
        }
    }
}
