/** @author 14991 */
public interface Map<K,V> {
    /**
     * 向 Map 中添加元素
     *
     * @param key key
     * @param value value
     */
    void add(K key, V value);

    /**
     * 在 Map 中移除 元素
     *
     * @param key 移除元素的key
     * @return 移除的元素
     */
    V remove(K key);

    /**
     * 是否存在 元素
     *
     * @param key 元素的key
     * @return boolean
     */
    boolean contains(K key);

    /**
     * 通过key 获取map中的元素
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 修改map中的值
     *
     * @param key 修改元素的key
     * @param newValue 修改元素的value
     */
    void set(K key, V newValue);

    /**
     * 获取map的大小
     *
     * @return 大小
     */
    int getSize();

    /**
     * 判断map 是否为空
     *
     * @return Boolean
     */
    boolean isEmpty();
}
