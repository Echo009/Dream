引用计数法
==========

在对象中添加一个引用计数器，当有地方引用这个对象的时候，引用计数器就+1，当引用失效的时候，引用计数器的值就-1。

问题
----

循环引用问题。
