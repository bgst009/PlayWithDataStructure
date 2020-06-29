// 给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
//
// 示例：
//
// 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
//
// sumRange(0, 2) -> 1
// sumRange(2, 5) -> -1
// sumRange(0, 5) -> -3
//
// 说明:
//
//
// 你可以假设数组不可变。
// 会多次调用 sumRange 方法。
//
// Related Topics 动态规划

// leetcode submit region begin(Prohibit modification and deletion)

class NumArray {

  private SegmentTree<Integer> segmentTree;

  public NumArray(int[] nums) {
    if (nums.length > 0) {
      Integer[] data = new Integer[nums.length];
      for (int i = 0; i < nums.length; i++) {
        data[i] = nums[i];
      }
      segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
    }
  }

  public int sumRange(int i, int j) {
    if (segmentTree == null) {
      throw new IllegalArgumentException("Segment Tree is null");
    }
    return segmentTree.query(i, j);
  }

  private interface Merger<E> {
    E merger(E a, E b);
  }

  private class SegmentTree<E> {

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
      buildSegmentTree(0, 0, arr.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l...r]的线段树
     *
     * @param treeIndex treeIndex的位置
     * @param l left
     * @param r right
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {

      if (l == r) {
        tree[treeIndex] = data[l];
        return;
      }

      int leftTreeIndex = leftChild(treeIndex);
      int rightTreeIndex = rightChild(treeIndex);

      // int mid = (l + r) / 2;
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

    /**
     * 返回区间[queryL, queryR]的值
     *
     * @param queryL left
     * @param queryR right
     * @return value
     */
    public E query(int queryL, int queryR) {

      if (queryL < 0
          || queryL >= data.length
          || queryR < 0
          || queryR >= data.length
          || queryL > queryR) {
        throw new IllegalArgumentException("Index is illegal.");
      }

      return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
     *
     * @param treeIndex treeIndex
     * @param l left
     * @param r right
     * @param queryL query left
     * @param queryR query right
     * @return value
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {

      if (l == queryL && r == queryR) {
        return tree[treeIndex];
      }

      int mid = l + (r - l) / 2;
      // treeIndex的节点分为[l...mid]和[mid+1...r]两部分

      int leftTreeIndex = leftChild(treeIndex);
      int rightTreeIndex = rightChild(treeIndex);
      if (queryL >= mid + 1) {
        return query(rightTreeIndex, mid + 1, r, queryL, queryR);
      } else if (queryR <= mid) {
        return query(leftTreeIndex, l, mid, queryL, queryR);
      }

      E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
      E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
      return merger.merger(leftResult, rightResult);
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
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// leetcode submit region end(Prohibit modification and deletion)
