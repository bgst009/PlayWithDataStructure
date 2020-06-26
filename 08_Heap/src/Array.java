import java.util.Arrays;

/**
 * @author yin_zhong_en
 * @version 1.0.0 @ClassName Array.java
 * @createTime 2020年05月23日 17:02:00
 */
public class Array<E> {

  private E[] data;
  private int size;

  /** @param capacity 容量 */
  public Array(int capacity) {
    data = (E[]) new Object[capacity];
    size = 0;
  }

  /** 无参构造函数 */
  public Array() {
    this(10);
  }

  public E[] getData() {
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
   */
  public void addLast(E e) {
    add(size, e);
  }

  /**
   * 在所有元素前添加一个新的元素
   *
   * @param e element
   */
  public void addFirst(E e) {
    add(0, e);
  }

  /**
   * 在 index 位置插入 元素 e
   *
   * @param index 索引
   * @param e element
   */
  public void add(int index, E e) {
    if (size == data.length) {
      resize(2 * data.length);
    }
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("AddLast failed. Array require index < 0 || index > size");
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
   */
  E get(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Get failed, Index is illegal.");
    }
    return data[index];
  }

  /**
   * 设置 index 索引位置的元素
   *
   * @param index 索引
   */
  void set(int index, E e) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Get failed, Index is illegal.");
    }
    data[index] = e;
  }

  /**
   * 查找数组中是否包含元素 e
   *
   * @param e element
   * @return boolean
   */
  public boolean contains(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(e)) {
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
  public int find(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(e)) {
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
   */
  public E remove(int index) {

    // index 合法性检测
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Remove failed. Index is illegal");
    }

    E ret = data[index];

    for (int i = index + 1; i < size; i++) {
      data[i - 1] = data[i];
    }

    size--;

    // 自动回收 //loitering objects
    data[size] = null;

    if (size == data.length / 4 && data.length / 2 != 0) {
      resize(data.length / 2);
    }

    return ret;
  }

  /**
   * 删除数组中的第一个元素，并返回删除元素的值
   *
   * @return 删除元素的值
   */
  public E removeFirst() {
    return remove(0);
  }

  /**
   * 删除数组中最后一个元素的值，并返回删除元素的值
   *
   * @return 删除元素的值
   */
  public E removeLast() {
    return remove(size - 1);
  }

  /**
   * 删除数组中的元素 e
   *
   * @param e 被删除的元素
   */
  public void removeElement(E e) {
    int index = find(e);
    if (index != -1) {
      remove(index);
    }
  }

  @Override
  public String toString() {
    return "Array{"
        + "data="
        + Arrays.toString(data)
        + ", size="
        + size
        + ", capacity="
        + data.length
        + '}';
  }

  /**
   * 动态数组扩充
   *
   * @param newCapacity 扩充容量大小
   */
  private void resize(int newCapacity) {
    E[] newData = (E[]) new Object[newCapacity];
    if (size >= 0) {
      System.arraycopy(data, 0, newData, 0, size);
    }
    data = newData;
  }

  public void swap(int i, int j) {
    if (i < 0 || i >= size || j < 0 || j >= size) {
      throw new IllegalArgumentException("Index is illiegal");
    }
    E t = data[i];
    data[i] = data[j];
    data[j] = t;
  }
}
