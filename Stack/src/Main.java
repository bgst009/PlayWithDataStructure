/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName Main.java
 * @createTime 2020年05月24日 10:27:00
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
