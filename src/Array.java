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

    /**
     * 查找数组中是否包含元素 e
     *
     * @param e element
     * @return boolean
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中包含元素的索引，并返回。如果不存在则返回 -1
     *
     * @param e element
     * @return index of element
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除 index 位置的元素并返回元素的值
     *
     * @param index 被删除元素的索引
     * @return 被删除元素的值
     * @throws IllegalAccessException 索引异常
     */
    public int remove(int index) throws IllegalAccessException {

        //index 合法性检测
        if (index < 0 || index >= size) {
            throw new IllegalAccessException("Remove failed. Index is illegal");
        }

        int ret = data[index];

        System.arraycopy(data, index + 1, data, index, size - index);
        size--;

        return ret;
    }

    /**
     * 删除数组中的第一个元素，并返回删除元素的值
     *
     * @return 删除元素的值
     * @throws IllegalAccessException 索引异常
     */
    public int removeFirst() throws IllegalAccessException {
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素的值，并返回删除元素的值
     *
     * @return 删除元素的值
     * @throws IllegalAccessException 索引异常
     */
    public int removeLast() throws IllegalAccessException {
        return remove(size - 1);
    }

    /**
     * 删除数组中的元素 e
     *
     * @param e 被删除的元素
     * @throws IllegalAccessException 索引异常
     */
    public void removeElement(int e) throws IllegalAccessException {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
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
