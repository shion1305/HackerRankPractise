# Weather Observation Station 18

## Problem

Consider and to be two points on a *2D* plane.

- `a` happens to equal the minimum value in *Northern Latitude* (*LAT_N* in **STATION**).
- ` b` happens to equal the minimum value in *Western Longitude* (*LONG_W* in **STATION**).
- `c` happens to equal the maximum value in *Northern Latitude* (*LAT_N* in **STATION**).
- `d` happens to equal the maximum value in *Western Longitude* (*LONG_W* in **STATION**).

Query the [Manhattan Distance](https://xlinux.nist.gov/dads/HTML/manhattanDistance.html) between points and and round it to a scale of decimal places.

> Manhattan Distance
>
> **Definition:** The distance between two points measured along axes at right angles. In a plane with p1 at (x1, y1) and p2 at (x2, y2), it is |x1 - x2| + |y1 - y2|.

### MySQL / Oracle Database

```mysql
SELECT ROUND(MAX(LAT_N)-MIN(LAT_N)+MAX(LONG_W)-MIN(LONG_W),4) FROM STATION;
```

なるほどね、って感じ..?

Select文先頭でもMax,Minは使えます。

その場合は出力は1行のみになる。

