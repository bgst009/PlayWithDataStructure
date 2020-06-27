public class SegmentTree<E> {
  private E[] tree;
  private E[] data;
  private Merger<E> merger;

  public SegmentTree(E[] arr, Merger<E> merger) {

    this.merger = merger;

    data = (E[]) new Object[arr.length];
    for (int i = 0; i < arr.length; i++) {
      data[i] = arr[i];
    }

    tree = (E[]) new Object[4 * arr.length];
    buildSegmentTree(0, 0, data.length - 1);
  }

  /**
   * 在treeIndex的位置创建表示区间[l...r]的线段树
   *
   * @param treeIndex treeIndex的位置
   * @param l left
   * @param r right
   */
  private void buildSegmentTree(int treeIndex, int l, int r) {

    // 递归到底
    if (l == r) {
      tree[treeIndex] = data[l];
      return;
    }

    int leftTreeIndex = leftChild(treeIndex);
    int rightTreeIndex = rightChild(treeIndex);

    int mid = l + (r - l) / 2;
    buildSegmentTree(leftTreeIndex, l, mid);
    buildSegmentTree(rightTreeIndex, mid + 1, r);

    tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
  }

  /**
   * 获取数据量大小
   *
   * @return 大小
   */
  public int getSize() {
    return data.length;
  }

  /**
   * 通过索引获取元素
   *
   * @param index 索引
   * @return 元素
   */
  public E get(int index) {
    if (index < 0 || index >= data.length) {
      throw new IllegalArgumentException("Index is illegal.");
    }
    return data[index];
  }

  /**
   * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
   *
   * @param index 索引
   * @return 左孩子节点的索引
   */
  private int leftChild(int index) {
    return 2 * index + 1;
  }

  /**
   * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
   *
   * @param index 索引
   * @return 右孩子节点的索引
   */
  private int rightChild(int index) {
    return 2 * index + 2;
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append('[');
    for (int i = 0; i < tree.length; i++) {
      if (tree[i] != null) {
        res.append(tree[i]);
      } else {
        res.append("null");
      }

      if (i != tree.length - 1) {
        res.append(", ");
      }
    }
    res.append(']');
    return res.toString();
  }
}
