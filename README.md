# PlayWithDataStructure

> MOOC 网 玩转数据结构 练习

## 集合的时间复杂度分析

|     | LinkedListSet | BSTSet  |
|-----| ------------- | -------- |
| 增 add | O(n) 节点n | O(h) 高度h |
| 查 contains | O(n) | O(h) = O(logn)|
| 删 remove| O(n) | O(h) = O(logn)|

二分搜索树有可能退化为链表，大多数情况为 **O(logn)** 但如果顺序添加元素则退化为链表 **O(n)**
 
 