标记-清除算法
=============

首先标记出所有需要回收的对象，在标记完成后统一回收掉所有被标记的对象，标记过程采用根搜索算法。

问题
----

-	效率问题，标记和清除的效率都不高
-	空间问题，标记清除之后会产生大量不连续的内存碎片，空间碎片太多可能会导致程序再以后得运行过程中需要分配较大对象时无法找到足够的连续内存而不得不提前触发另一次垃圾收集动作。
