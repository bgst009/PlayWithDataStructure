package Leetcode;
// 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//
//
// 示例 1:
//
// 输入: nums = [1,1,1,2,2,3], k = 2
// 输出: [1,2]
//
//
// 示例 2:
//
// 输入: nums = [1], k = 1
// 输出: [1]
//
//
//
// 提示：
//
//
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
// 你可以按任意顺序返回答案。
//
// Related Topics 堆 哈希表

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {

  public int[] topKFrequent(int[] nums, int k) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }

    PriorityQueue<Freq> pq = new PriorityQueue<>();
    for (int key : map.keySet()) {
      if (pq.size() < k) {
        pq.add(new Freq(key, map.get(key)));
      } else if (map.get(key) > pq.peek().freq) {
        pq.remove();
        pq.add(new Freq(key, map.get(key)));
      }
    }

    LinkedList<Integer> resList = new LinkedList<>();
    while (!pq.isEmpty()) {
      resList.add(pq.remove().e);
    }

    int[] res = new int[resList.size()];
    for (int i = 0; i < resList.size(); i++) {
      res[i] = resList.get(i);
    }

    return res;
  }

  private class Freq implements Comparable<Freq> {

    public int e, freq;

    public Freq(int e, int freq) {
      this.e = e;
      this.freq = freq;
    }

    @Override
    public int compareTo(Freq another) {
      if (this.freq < another.freq) {
        return -1;
      } else if (this.freq > another.freq) {
        return 1;
      } else {
        return 0;
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
