public interface Set<E> {

    /**
     * 向Set中添加元素
     *
     * @param e 添加元素
     */
    void add(E e);

    /**
     * 判断Set中是否存在元素e
     *
     * @param e 元素e
     * @return Boolean
     */
    boolean contains(E e);

    /**
     * 在Set中移除元素 e
     *
     * @param e 移除元素
     */
    void remove(E e);

    /**
     * 获取Set的大小
     *
     * @return Set大小
     */
    int getSize();

    /**
     * 判断Set是否为空
     *
     * @return Boolean
     */
    boolean isEmpty();
}
