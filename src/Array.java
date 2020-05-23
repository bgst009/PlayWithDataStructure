import jdk.jfr.BooleanFlag;

import java.util.Arrays;

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
     * @param capacity 容量
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

    /**
     * 向数组中添加元素
     *
     * @param e element
     * @throws IllegalAccessException 索引异常
     */
    public void addLast(int e) throws IllegalAccessException {
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新的元素
     *
     * @param e element
     */
    public void addFirst(int e) throws IllegalAccessException {
        add(0, e);
    }

    /**
     * 在 index 位置插入 元素 e
     *
     * @param index 索引
     * @param e     element
     * @throws IllegalAccessException 索引异常
     */
    public void add(int index, int e) throws IllegalAccessException {
        if (size == data.length) {
            throw new IllegalAccessException("AddLast failed. Array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalAccessException("AddLast failed. Array require index < 0 || index > size");
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    /**
     * 获取 index 索引位置的元素
     *
     * @param index 索引
     * @return data[index]
     * @throws IllegalAccessException 索引异常
     */
    int get(int index) throws IllegalAccessException {
        if (index < 0 || index >= size) {
            throw new IllegalAccessException("Get failed, Index is illegal.");
        }
        return data[index];
    }

    /**
     * 设置 index 索引位置的元素
     *
     * @param index 索引
     * @throws IllegalAccessException 索引异常
     */
    void set(int index, int e) throws IllegalAccessException {
        if (index < 0 || index >= size) {
            throw new IllegalAccessException("Get failed, Index is illegal.");
        }
        data[index] = e;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + data.length +
                '}';
    }
}
