import java.util.TreeMap;

public class Trie {
  private Node root;
  private int size;

  public Trie() {
    root = new Node();
    size = 0;
  }

  /**
   * 获得Trie中存储的单词数量
   *
   * @return 存储的单词数量
   */
  public int getSize() {
    return size;
  }

  /**
   * 向Trie中添加一个新的单词word
   *
   * @param word 单词word
   */
  public void add(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (curr.next.get(c) == null) {
        curr.next.put(c, new Node());
      }
      curr = curr.next.get(c);
    }

    if (!curr.isWord) {
      curr.isWord = true;
      size++;
    }
  }

  /**
   * 查询单词word是否在Trie中
   *
   * @param word 单词word
   * @return boolean
   */
  public boolean contains(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (curr.next.get(c) == null) {
        return false;
      }
      curr = curr.next.get(c);
    }
    return curr.isWord;
  }

  /**
   * 查询是否在Trie中有单词以prefix为前缀
   *
   * @param prefix 前缀
   * @return boolean
   */
  public boolean isPrefix(String prefix) {

    Node cur = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (cur.next.get(c) == null) {
        return false;
      }
      cur = cur.next.get(c);
    }

    return true;
  }

  private class Node {
    boolean isWord;
    TreeMap<Character, Node> next;

    public Node(boolean isWord) {
      this.isWord = isWord;
      next = new TreeMap<>();
    }

    public Node() {
      this(false);
    }
  }
}
