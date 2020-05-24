/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName Stack.java
 * @createTime 2020年05月24日 09:48:00
 */
public interface Stack<E> {
    /**
     * 获取栈的大小
     *
     * @return 栈大小
     */
    int getSize();

    /**
     * 判读栈是否为空
     *
     * @return bool
     */
    boolean isEmpty();

    /**
     * 压栈
     *
     * @param e 入栈元素
     */
    void push(E e) throws IllegalAccessException;

    /**
     * 弹栈
     *
     * @return 栈顶元素
     */
    E pop() throws IllegalAccessException;

    /**
     * 获取栈顶元素
     *
     * @return 栈顶元素
     */
    E peek() throws IllegalAccessException;
}
