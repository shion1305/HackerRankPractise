# Weather Observation Station 11

## Problem

Query the list of *CITY* names from **STATION** that either do not start with vowels or do not end with vowels. Your result cannot contain duplicates.

## 正規表現を用いた場合(LIKE)

### MySQL

```mysql
SELECT DISTINCT CITY FROM STATION WHERE
NOT (CITY LIKE "%a" OR CITY LIKE "%i" OR CITY LIKE "%u" OR CITY LIKE "%e" OR CITY LIKE "%o")
OR NOT (CITY LIKE "a%" OR CITY LIKE "i%" OR CITY LIKE "u%" OR CITY LIKE "e%" OR CITY LIKE "o%");
```

### Oracle Database

```plsql
SELECT DISTINCT CITY FROM STATION WHERE
NOT (LOWER(CITY) LIKE '%a' OR LOWER(CITY) LIKE '%i' OR LOWER(CITY) LIKE '%u' OR LOWER(CITY) LIKE '%e' OR LOWER(CITY) LIKE '%o')
OR NOT (LOWER(CITY) LIKE 'a%' OR LOWER(CITY) LIKE 'i%' OR LOWER(CITY) LIKE 'u%' OR LOWER(CITY) LIKE 'e%' OR LOWER(CITY) LIKE 'o%');
```



- OracleでもMySQLでも演算子の優先順位は`NOT` > `AND` > `OR` であることに注意。

## 正規表現を用いた場合(POSIX正規表現)

### MySQL

```mysql
SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP "^[^AIUEO]" OR CITY REGEXP "[^AIUEO]$";
```

### Oracle Database

```plsql
SELECT DISTINCT CITY FROM STATION WHERE REGEXP_LIKE(CITY,'^[^AIUEO]','i') OR REGEXP_LIKE(CITY,'[^AIUEO]$','i');
```

第3引数の`i`は大文字小文字をIgnoreする=Not Case Sensitiveの意でのオプション。

## String操作

### MySQL

```mysql
SELECT DISTINCT CITY FROM STATION WHERE LEFT(CITY,1) NOT IN ('A','I','U','E','O') OR RIGHT(CITY,1) NOT IN ('A','I','U','E','O');
```

### Oracle Database / MySQL

```plsql
SELECT DISTINCT CITY FROM STATION WHERE UPPER(SUBSTR(CITY,1,1)) NOT IN ('A','I','U','E','O') OR UPPER(SUBSTR(CITY,-1,1)) NOT IN ('A','I','U','E','O')
```
