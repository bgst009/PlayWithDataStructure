// 我们的第四版Union-Find
public class UnionFind6 implements UF {

  /** rank[i]表示以i为根的集合所表示的树的层数 */
  private int[] rank;
  /** parent[i]表示第i个元素所指向的父节点 */
  private int[] parent;

  public UnionFind6(int size) {

    rank = new int[size];
    parent = new int[size];

    // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
    for (int i = 0; i < size; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }

  @Override
  public int getSize() {
    return parent.length;
  }

  /**
   * 查找元素p所对应的集合编号
   *
   * @param p 元素p
   * @return 集合编号
   */
  private int find(int p) {
    if (p < 0 || p >= parent.length) {
      throw new IllegalArgumentException("p is out of bound.");
    }

    // path compression 2, 递归算法
    if (p != parent[p]) {
      parent[p] = find(parent[p]);
    }
    return parent[p];
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

    // 根据两个元素所在树的rank不同判断合并方向
    // 将rank低的集合合并到rank高的集合上
    if (rank[pRoot] < rank[qRoot]) {
      parent[pRoot] = qRoot;
    } else if (rank[qRoot] < rank[pRoot]) {
      parent[qRoot] = pRoot;
    } else { // rank[pRoot] == rank[qRoot]
      parent[pRoot] = qRoot;
      rank[qRoot] += 1; // 此时, 我维护rank的值
    }
  }
}
