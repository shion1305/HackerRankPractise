# Weather Observation Station 7

## Stringの操作を用いた場合

### MySQL

```mysql
SELECT DISTINCT CITY FROM STATION
WHERE RIGHT(CITY,1) IN ('A','I','U','E','O');
```

MySQLはNot Case Sensitiveである。

### Oracle Database

```plsql
SELECT DISTINCT CITY FROM STATION
WHERE LOWER(SUBSTR(CITY,-1)) IN ('a','i','u','e','o');
```

Oracle Databaseの場合はNegative Indexを用いることで最後の文字列の取り出しを行うことができる。

また、Oracle Databaseの場合はCase Sensitiveであることに注意。UpperかLowerを用いて大文字か小文字に変換してからマッチする。

## 正規表現を用いた場合(POSIX正規表現)

### MySQL

```mysql
SELECT DISTINCT CITY FROM STATION
WHERE CITY REGEXP ".*[aiueo]$";
```

### Oracle Database

```plsql
SELECT DISTINCT city 
FROM station 
WHERE REGEXP_LIKE(CITY, '.*[aiueo]$');
```

今更なのだが、`REGEXP_LIKE`を用いる場合、そのparenthesisには`"`は使えず`'`で括らなければならないらしい。

### MySQL Server

質問中...





## 正規表現を用いた場合(LIKE)

### MySQL / Oracle Database / DB2 / MySQL Server

```mysql
SELECT DISTINCT city 
FROM   station 
WHERE  city LIKE '%a' 
OR     city LIKE '%e' 
OR     city LIKE '%i' 
OR     city LIKE '%o' 
OR     city LIKE '%u';
```

なんと!! MySQLのLIKE文では`[AIUEO]`みたいに複数の文字一致は使えないらしい。

MySQL Serverのみ使えるみたいだが。

### MySQL Server

```mysql
SELECT DISTINCT(CITY) FROM STATION WHERE CITY LIKE '%[AEIOU]';
```

