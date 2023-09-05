```bash
keys *  # 查看素有key
existes keyName  # 某个key是否存在
get keyname # 查看某个key的val
expire keyName second #设置key的过期时间 ，second秒后过期
ttl keyName # keyname 还有多长时间过期
type keyname # 查看key的value 的类型
flushdb #清空当前数据库【redis—cli 连接redis。默认再第一个数据库】
flushall # 清空所有数据库【config 配置数据库数量，默认16】
```



```bash
append key val  # 给key的值上追加val，如果key不存在，相当于给key赋值val

incr key # key的val自增+1

decr key # key的val自减 -1

incrby key step # key的val增加 step

decrby key step # key的val减少 step

getrange key start end # 获取key的val 的[start,end]值（闭区间,index从0开始）

setrange key offset val # 设置key的val 从offset开始的值，替换为 val 
#eg: "key1"："abcde" setrange key1 1 xxx.  结果： "key1":"axxxde";


```

