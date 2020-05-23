import jdk.jfr.BooleanFlag;

/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName Array.java
 * @createTime 2020年05月23日 17:02:00
 */
public class Array {

    private int[] data;
    private int size;

    /**
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
    }

    /**
     * 无参构造函数
     */
    public Array() {
        this(10);
    }

    public int[] getData() {
        return data;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
