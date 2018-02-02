# 大数据中的基础概念

## [数据仓库(Data Warehouse)](https://baike.baidu.com/item/%E6%95%B0%E6%8D%AE%E4%BB%93%E5%BA%93)
### 分层
- DWD ：data warehouse detail ， 细节数据层，有的也称ODS层，是业务层与数据仓库的隔离层 。
- DWB ：data warehouse base ， 基础数据层，存储的是客观数据，一般作中间层，可以认为是大量指标的数据层 。
- DWS : data warehouse service , 服务数据层，基于DWB 上的基础数据，整合汇总成分析某一个主题域的服务数据，一般是宽表。

## 埋点
在应用中特定的收集一些信息，用于跟踪应用使用的状况，后续用来进一步优化产品或是提供运营的数据的支撑，包括访问（Visits），访客（Visitor），停留时间（Time on site），页面访问量（Page views） ，跳出率（Bounce rate）

这样的信息收集可以大致分为两种

- 页面统计
- 操作行为统计

## SEM
search engine marketing , 搜索引擎营销，根据用户使用搜索引擎的方式利用用户检索信息的机会尽可能的将营销信息传递给用户。

## DM
data mining , 数据挖掘，一般指从大量数据中使用算法发现隐藏于其中的的信息的过程。

## 数据倾斜
data skew , 在计算数据的时候，数据分散度不够，导致大量的数据集中到了一台或者几台机器上计算，这些数据的计算速度远远低于平均速度，导致整个计算过程过慢。


