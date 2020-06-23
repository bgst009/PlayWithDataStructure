public class BSTSet<E extends Comparable<E>> implements Set<E> {
  private BST<E> bst;

  public BSTSet() {
    bst = new BST<>();
  }

  /**
   * 向Set中添加元素
   *
   * @param e 添加元素
   */
  @Override
  public void add(E e) {
    bst.add(e);
  }

  /**
   * 判断Set中是否存在元素e
   *
   * @param e 元素e
   * @return Boolean
   */
  @Override
  public boolean contains(E e) {
    return bst.contains(e);
  }

  /**
   * 在Set中移除元素 e
   *
   * @param e 移除元素
   */
  @Override
  public void remove(E e) {
    bst.remove(e);
  }

  /**
   * 获取Set的大小
   *
   * @return Set大小
   */
  @Override
  public int getSize() {
    return bst.size();
  }

  /**
   * 判断Set是否为空
   *
   * @return Boolean
   */
  @Override
  public boolean isEmpty() {
    return bst.isEmpty();
  }
}
