# Weather Observation Station 19

## Problem

​	Consider P₁(a, c) and P₂(b, d) to be two points on a 2D plane where (a, b) are the respective minimum and maximum values of *Northern Latitude* (*LAT_N*) and (c, d) are the respective minimum and maximum values of *Western Longitude* (*LONG_W*) in **STATION**.

​	Query the [Euclidean Distance](https://en.wikipedia.org/wiki/Euclidean_distance) between points P₁ and P₂ and *format your answer* to display 4 decimal digits.

### MySQL / Oracle Database

```mysql
select round(sqrt((max(lat_n)-min(lat_n))*(max(lat_n)-min(lat_n))+(max(long_w)-min(long_w))*(max(long_w)-min(long_w))),4) from station;
```

### MySQL

```mysql
select round(sqrt(pow(max(lat_n)-min(lat_n),2)+pow(max(long_w)-min(long_w),2)),4) from station;
```

### Oracle Database / MySQL

```plsql
select round(sqrt(power(max(lat_n)-min(lat_n),2)+power(max(long_w)-min(long_w),2)),4) from station;
```

`POW` / `POWER`関数を使うともっと簡潔に書ける。

`POW`は`MySQL`のみ。Oracle Databaseでは`power`を使う必要がある。