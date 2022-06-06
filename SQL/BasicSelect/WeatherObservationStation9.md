# Weather Observation Station 9

## 正規表現による処理(POSIX正規表現)

### MySQL

```mysql
SELECT DISTINCT CITY FROM STATION WHERE CITY NOT REGEXP '^[AIUEO]';
```

```mysql
SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP '^[^AIUEO]';
```



### Oracle Database

```plsql
SELECT DISTINCT CITY FROM STATION WHERE NOT REGEXP_LIKE(CITY,'^[AIUEO]');
```

```plsql
SELECT DISTINCT CITY FROM STATION WHERE REGEXP_LIKE(CITY,'^[^AIUEO]');
```







## 正規表現による処理(LIKE正規表現)

### MySQL

```mysql
select distinct city from station
where city NOT LIKE 'a%' and city NOT LIKE 'i%' and city NOT LIKE 'u%' and city NOT LIKE 'e%' and city NOT LIKE 'o%';
```

としてもよいし、

### MySQL

```mysql
select distinct city from station
where not (city LIKE 'a%' OR city LIKE 'i%' OR city LIKE 'u%' OR city LIKE 'e%' OR city LIKE 'o%');
```

としてもよい。後者の方が簡潔。

### Oracle Database / MySQL

```plsql
select distinct city from station
where not (city LIKE 'A%' OR city LIKE 'I%' OR city LIKE 'U%' OR city LIKE 'E%' OR city LIKE 'O%');
```

## Stringの操作による解法

### MySQL

```mysql
SELECT DISTINCT CITY FROM STATION WHERE LEFT(CITY,1) NOT in ('a','i','u','e','o');
```

### Oracle Database / MySQL

```plsql
SELECT DISTINCT CITY FROM STATION WHERE SUBSTR(CITY,1,1) NOT IN ('A','I','U','E','O');
```

#### SUBSTRの使い方(Oracle Database / MySQL)

SUBSTR(`文字列`,`開始文字の位置`,`取得する文字列の長さ`)というように使う。

SUBSTR(`文字列`,`開始文字の位置`)の2引数を用いた場合は、開始文字から最後までを返す。

開始文字列は、1文字目は0ではなく1である。
