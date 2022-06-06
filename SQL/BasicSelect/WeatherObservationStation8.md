# Weather Observation Station 8

## 正規表現を用いた場合(LIKE)

### MySQL Server

```mysql
SELECT DISTINCT city 
FROM   station 
WHERE  city LIKE '[aiueo]%[aiueo]';
```

Likeでしっかりとした正規表現を使えない他のデータベースになってくるとめんどいがこんな感じで組むこともできる。

### Oracle Database ( / MySQL)

```plsql
SELECT city
FROM station
WHERE (
   LOWER(city) LIKE 'a%' 
   OR LOWER(city) LIKE 'e%' 
   OR LOWER(city) LIKE 'i%' 
   OR LOWER(city) LIKE 'o%' 
   OR LOWER(city) LIKE 'u%'
)
AND (
   LOWER(city) LIKE '%a' 
   OR LOWER(city) like '%e' 
   OR LOWER(city) LIKE '%i' 
   OR LOWER(city) LIKE '%o' 
   OR LOWER(city) LIKE '%u'
);
```

### MySQL

```mysql
SELECT city
FROM station
WHERE (
   city LIKE 'a%' 
   OR city LIKE 'e%' 
   OR city LIKE 'i%' 
   OR city LIKE 'o%' 
   OR city LIKE 'u%'
)
AND (
   city LIKE '%a' 
   OR city like '%e' 
   OR city LIKE '%i' 
   OR city LIKE '%o' 
   OR city LIKE '%u'
);
```

## 正規表現を用いた場合(POSIX正規表現)

### MySQL

```mysql
SELECT DISTINCT city 
FROM   station 
WHERE  city REGEXP '^[aiueo].*[aiueo]$';
```

### Oracle Database

```plsql
SELECT DISTINCT city 
FROM station 
WHERE REGEXP_LIKE(LOWER(CITY),'^[aiueo].*[aiueo]$');
```

Case Sensitiveに配慮してLOWERを使う必要がある。

### Oracle Database

```plsql
SELECT DISTINCT CITY FROM STATION WHERE REGEXP_LIKE(CITY,'^[AIUEO].*[AIUEO]$','i');
```

第3引数にIgnoreの`i`を付けるとNot Case Sensitiveになってくれるらしい..!便利!

## Stringの操作を用いた場合

### MySQL

```mysql
select distinct city from station 
where left(city,1) in ('a','e','i','o','u') 
and right(city, 1) in ('a','e','i','o','u')
```
