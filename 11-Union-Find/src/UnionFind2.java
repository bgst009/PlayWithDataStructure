public class UnionFind2 implements UF {
  private int[] parent;

  public UnionFind2(int size) {
    parent = new int[size];

    for (int i = 0; i < size; i++) {
      parent[i] = i;
    }
  }

  /**
   * 查找元素p所对应的集合编号
   *
   * @param p 元素p
   * @return 集合编号
   */
  private int find(int p) {
    while (p != parent[p]) {
      p = parent[p];
    }
    return p;
  }

  @Override
  public int getSize() {
    return 0;
  }

  /**
   * 查看元素p和元素q是否所属一个集合
   *
   * @param p 元素p
   * @param q 元素q
   * @return boolean
   */
  @Override
  public boolean isConnected(int p, int q) {
    return find(p) == find(q);
  }

  /**
   * 合并元素p和元素q所属的集合 O(h)复杂度, h为树的高度
   *
   * @param p 元素p
   * @param q 元素q
   */
  @Override
  public void unionElements(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);

    if (pRoot == qRoot) {
      return;
    }

    parent[p] = qRoot;
  }
}
