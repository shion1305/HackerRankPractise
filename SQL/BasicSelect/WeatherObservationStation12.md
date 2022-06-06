# Weather Observation Station 12

## Problem

Query the list of *CITY* names from **STATION** that *do not start* with vowels and *do not end* with vowels. Your result cannot contain duplicates.

## 正規表現を使った解法(POSIX正規表現)

### MySQL

```mysql
SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP '^[^aiueo].*[^aiueo]$';
```

### Oracle Database

```plsql
SELECT DISTINCT CITY FROM STATION WHERE REGEXP_LIKE(CITY,'^[^auieo].*[^aiueo]$','i');
```

他の解法は冗長すぎるので省略します。