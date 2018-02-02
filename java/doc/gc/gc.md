垃圾回收
========

如何判断一个对象是否为可回收对象
--------------------------------

-	[引用计数法](./judgement/reference-count.md)
-	[可达性分析法](./judgement/reachable-analyze.md)

垃圾回收算法
------------

-	[标记-清除](./collection-algorithm/mark-sweep.md)
-	[复制](./collection-algorithm/copy.md)
-	[标记整理](./collection-algorithm/mark-compact.md)
-	[分代回收](./collection-algorithm/generational-collection.md)

相关运行参数
------------

打印GC日志

-	-verbose:gc
-	-XX:+PrintGCDetails
