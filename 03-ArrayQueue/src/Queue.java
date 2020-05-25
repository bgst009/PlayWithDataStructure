/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName Queue.java
 * @createTime 2020年05月24日 14:04:00
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
