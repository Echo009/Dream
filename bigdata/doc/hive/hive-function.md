# 常用函数
## 条件函数

### IF 函数

```sql
IF(boolean condition ,
   T valueTrue ,
   T valueFalseOrNull);
```
当条件condition为true的时候，返回valueTrue，为false或者为空的时候，返回valueFalseOrNull。

### 非空查找函数 COALESCE 
```sql
COALESCE(T v1,T v2, ...)
```
返回参数中的第一个非空值 。

### 条件判断函数 CASE
```sql
CASE a WHEN b THEN c 
[WHEN c then e]*  
[ELSE f]
END  
```
如果a等于b，那么返回c ； 如果a等于c，则返回e ；否则返回f 。如果没有else子句，且在没有匹配项的时候返回空值。

还可以是如下形式：
```sql
CASE 
WHEN condition1 THEN a 
[WHEN condition2 THEN b]*
[ELSE c]
END 
```

## 字符串函数
### LENGTH
```sql
LENGTH(string str)
```
返回字符串str的长度，需要注意的是如果str为null则返回的是null值。

### REVERSE
```sql
REVERSE(String str)
```

### CONCAT
```sql
CONCAT(string A , String B ...)
```
### CONCAT_WS
```sql
CONCAT_WS(String separator,String A ,String B , ...)
```
Tips:可传入数组作为参数

### substr / substring 
```sql
SUBSTRING (String str , int A)
```
返回字符串str从下标A开始到末尾的字符串，以下标1为起始位置，如果为负数则从末尾开始取，如substring('lanlan',-2) 返回结果为 an 。

### upper,ucase 

...

### lower,lcase 

...

### trim , ltrim , rtrim
ltrim , 去除左边的空格。

rtrim , 去除右边的空格。

### regexp_replace 正则表达式替换函数
```sql
regexp_replace(string A, string B, string C)
```
将字符串A中的符合java正则表达式B的部分替换为C。注意，在有些情况下要使用转义字符,类似oracle中的regexp_replace函数。

### 正则表达式解析函数 regexp_extract 
```sql
regexp_extract(string subject, string pattern, int index)
```
将字符串subject按照pattern正则表达式的规则拆分，返回index指定的字符。

如 select regexp_extract('LAN','(L)(A)(N)',2); 返回 A 。

### url解析函数 parse_url 
```sql
parse_url(string urlString, string partToExtract [, stringkeyToExtract])
```
返回URL中指定的部分。partToExtract的有效值为：HOST, PATH, QUERY, REF, PROTOCOL, AUTHORITY, FILE, and USERINFO。

### json解析函数 get_json_object 
```sql
get_json_object(string json_string, string path)
```
解析json的字符串json_string,返回path指定的内容。如果输入的json字符串无效，那么返回NULL。

### 空格字符串函数 space 
```sql
space(int n)
```
返回长度为n的字符串 。

### 重复字符串函数 repeat
```sql
repeat(string str, int n)
```
返回重复n次后的str字符串 。

### 首字符ascii函数，ascii
```sql
ascii(string str)
```
返回字符串str第一个字符的ascii码。

### 左补足函数,lpad
```sql
lpad(string str, int len, string pad)
```
将str进行用pad进行左补足到len位,注意：与GP，ORACLE不同，pad不能默认。

### 右补足函数，rpad

### 分割字符串函数，split
```sql
split(string str, stringpat)
```
### 集合查找函数，find_in_set
```sql
find_in_set(string str, string strList)
```
返回str在strlist第一次出现的位置，strlist是用逗号分割的字符串。如果没有找该str字符，则返回0 。

## 集合统计函数

- count
- sum
- avg
- min
- max 

## 聚合函数

### collect_set

```sql
collect_set(colName)
```
参数只能为基本数据类型，将某字段的值去重，产生Array类型的字段，一般配合group by使用，将多行记录转换成一条记录。

### explode

```sql
explode(Array)
```
仅接受Array类型的参数，与collect_set函数的作用正好相反，实现将Array类型的数据行转列。一般配合LATERAL VIEW 使用将一行记录拆分成多行记录。

## 窗口函数

### row_number() 

```sql
row_number() over (distribute by col1 sort by col2)
```

按col1 进行分组，组内根据 col2 进行排序，生成数字编号（行号）

## 日期相关函数

### next_day

```sql
next_day( date, weekday)
```

weekday is a day of the week (ie: SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY) 

 当第二个参数传的星期数比现有星期数小的时候，会返回下一个星期的日期；当第二个参数所传的星期数比 现有的星期数大的时候，则会返回本周的相应星期日期。
 
 ### date_sub
 
 ```sql
 date_sub(date,interval expr type)
```
 从日期减去指定的时间间隔
 
 