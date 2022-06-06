# Weather Observation Station 10

## Stringの操作による解法

### MySQL

```mysql
SELECT DISTINCT CITY FROM STATION WHERE SUBSTR(CITY,-1,1) NOT IN ('A','I','U','E','O');
```

### Oracle Database

```plsql
SELECT DISTINCT CITY FROM STATION WHERE UPPER(SUBSTR(CITY,-1,1)) NOT IN ('A','I','U','E','O');
```

### MySQL

```mysql
SELECT DISTINCT CITY FROM STATION WHERE RIGHT(CITY,1) NOT IN ('a','i','u','e','o');
```

## 正規表現による解法(LIKE)

### MySQL / Oracle Database

```mysql
SELECT DISTINCT CITY FROM STATION WHERE 
NOT(CITY LIKE '%a' or CITY LIKE '%i' OR CITY LIKE '%u' OR CITY LIKE '%e' OR CITY LIKE '%o');
```

MySQLでは`"`が使えるが、Oracle Databaseでは`'`が使えないことに注意。

## 正規表現による解法(POSIX正規表現)

### MySQL / Oracle Database

```mysql
SELECT DISTINCT CITY FROM STATION WHERE 
NOT REGEXP_LIKE(CITY,'.*[aiueo]$');
```

### MySQL

```mysql
SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP ".*[^aiueo]$"
```

