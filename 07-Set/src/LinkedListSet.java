/**
 * @author 14991
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    /**
     * 向Set中添加元素
     *
     * @param e 添加元素
     */
    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }

    /**
     * 判断Set中是否存在元素e
     *
     * @param e 元素e
     * @return Boolean
     */
    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    /**
     * 在Set中移除元素 e
     *
     * @param e 移除元素
     */
    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    /**
     * 获取Set的大小
     *
     * @return Set大小
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * 判断Set是否为空
     *
     * @return Boolean
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
