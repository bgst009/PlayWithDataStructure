// 实现一个 MapSum 类里的两个方法，insert 和 sum。
//
// 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
//
// 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
//
// 示例 1:
//
// 输入: insert("apple", 3), 输出: Null
// 输入: sum("ap"), 输出: 3
// 输入: insert("app", 2), 输出: Null
// 输入: sum("ap"), 输出: 5
//
// Related Topics 字典树
// 👍 47 👎 0

import java.util.TreeMap;

// leetcode submit region begin(Prohibit modification and deletion)
class MapSum {
  /** Initialize your data structure here. */
  private Node root;

  public MapSum() {
    root = new Node();
  }

  public void insert(String word, int val) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (curr.next.get(c) == null) {
        curr.next.put(c, new Node());
      }
      curr = curr.next.get(c);
    }
    curr.value = val;
  }

  public int sum(String prefix) {
    Node curr = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (curr.next.get(c) == null) {
        return 0;
      }
      curr = curr.next.get(c);
    }
    return sum(curr);
  }

  private int sum(Node node) {
    int res = node.value;
    for (char c : node.next.keySet()) {
      res += sum(node.next.get(c));
    }
    return res;
  }

  private class Node {
    int value;
    TreeMap<Character, Node> next;

    public Node(int val) {
      this.value = val;
      next = new TreeMap<>();
    }

    public Node() {
      this(0);
    }
  }
}

/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new MapSum();
 * obj.insert(key,val); int param_2 = obj.sum(prefix);
 */
// leetcode submit region end(Prohibit modification and deletion)
