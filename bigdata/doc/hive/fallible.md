# 需要注意的一些规则
## sub-queries
- 子查询中不允许出现同名列，如果存在同名，则应使用别名。

## group by 
- 分组查询指定分组列时，不能使用别名，需使用原来的列名。
- select 子句中除了函数外，其他列需要出现在group by 子句中。

## join
- 使用join连接表时，连接条件中用比较的两个列类型需要保持一致。

如：
```sql
SELECT * FROM a JOIN b ON a.id=b.id;
```
那么当a.id和b.id的数据类型不一致时，查询结果则不会正确。