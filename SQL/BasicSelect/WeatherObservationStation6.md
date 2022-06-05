# 問題

Query the list of *CITY* names starting with vowels (i.e., `a`, `e`, `i`, `o`, or `u`) from **STATION**. Your result *cannot* contain duplicates.

## 問題のポイント

- 正規表現を用いた検索
- 正規表現でのCASE SENSITIVEとNOT CASE SENSITIVE



## 正規表現を用いる場合(LIKE)

### MySQL / Oracle Database / DB2

```plsql
select distinct city from station
where city like 'A%' 
    or city like 'E%' 
    or city like 'I%' 
    or city like 'O%' 
    or city like 'U%';
```

Oracle DatabaseやDB2の場合は**<u>Case Sensitive</u>**であることに注意。

この問題では次の解法は正しくヒットしない。

### MySQL

```mysql
select distinct city
from station
where city like 'a%' 
    or city like 'e%' 
    or city like 'i%' 
    or city like 'o%' 
    or city like 'u%';
```



`%`は0文字以上の文字列の並びとヒットする。正規表現での`.*`と同じ

`_`は任意の一文字とヒット。正規表現での`.`と同じ

この例が分かりやすい。

> ```mysql
> 'abc' LIKE 'abc'    true
> 'abc' LIKE 'a%'     true
> 'abc' LIKE '_b_'    true
> 'abc' LIKE 'c'      false
> ```
>
> https://www.postgresql.jp/document/9.4/html/functions-matching.html より。

## 正規表現を用いる場合(REGEXP)(POSIX準拠)

### MySQL

```mysql
SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP "^[aiueo].*";
```

WHEREでの条件指定でregexp属性をつけ、正規表現で指定してあげればよい。

MySQLではNot Case Sensitiveである。よって上記では小文字大文字両方にヒットする。

MySQLでCase Sensitiveにするには、`BINARY`をくっつけてあげる。

MySQLの場合のREGEXPはnot case sensitiveであることに注意。

### MySQL

```mysql
SELECT CITY FROM STATION WHERE CITY REGEXP BINARY "^[AIUEO].*";
```

### Oracle Database

```plsql
SELECT DISTINCT CITY FROM STATION WHERE REGEXP_LIKE(CITY, '^[AIUEO].*');
```

Oracle DatabaseでPOSIX正規表現を用いてを指定する場合は`REGEXP_LIKE`関数を利用する必要がある。

`REGEXP_LIKE`を用いた場合の正規表現はCase Sensitiveである。



## Stringの操作によるマッチ

### Oracle Database

```plsql
SELECT DISTINCT CITY FROM STATION WHERE SUBSTR(CITY,0,1) IN ('A','I','U','E','O');
```

`SUBSTR`関数を用いて切り出し、それが条件のSTRINGにマッチするかどうかで判定している。

### MySQL

```mysql
SELECT DISTINCT city from station WHERE LEFT(CITY, 1) IN ('a', 'e', 'i', 'o', 'u');
```

`LEFT`関数を用いて左から1文字目、つまり先頭を取り出し`IN`にマッチするかを確かめるものである。**<u>Not Case Sensitive</u>** (LEFT関数はOracle Databaseではない)

## 参考にしたサイト

[](https://www.postgresql.jp/document/9.4/html/functions-matching.html)