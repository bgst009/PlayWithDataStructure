/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName LinkedListStack.java
 * @createTime 2020年05月25日 10:47:00
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    /**
     * 获取栈的大小
     *
     * @return 栈大小
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * 判读栈是否为空
     *
     * @return bool
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 压栈
     *
     * @param e 入栈元素
     */
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    /**
     * 弹栈
     *
     * @return 栈顶元素
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * 获取栈顶元素
     *
     * @return 栈顶元素
     */
    @Override
    public E peek() {
        return list.getFirst();
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
