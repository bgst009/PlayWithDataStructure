/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName ArrayStack.java
 * @createTime 2020年05月24日 10:09:00
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) throws IllegalAccessException {
        array.addLast(e);
    }

    @Override
    public E pop() throws IllegalAccessException {
        return array.removeLast();
    }

    @Override
    public E peek() throws IllegalAccessException {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            try {
                res.append(array.get(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(i!=array.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
