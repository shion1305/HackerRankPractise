# Higher Than 75 Marks



### MySQL

```mysql
SELECT NAME FROM STUDENTS WHERE MARKS>75 ORDER BY RIGHT(NAME,3) ASC, ID ASC;
```

### MySQL

```mysql
SELECT NAME FROM STUDENTS WHERE MARKS>75 ORDER BY SUBSTRING(NAME,-3) ASC, ID ASC;
```

面白いの見つけた。MySQLではSUBSTRINGも使えるらしい。より直感的（いや助長か..?）

### Oracle Database / MySQL

```plsql
SELECT NAME FROM STUDENTS WHERE MARKS>75 ORDER BY SUBSTR(NAME,-3) ASC, ID ASC;
```

ちなみにデフォルトでASCとなるように設定されているのでASCは書く必要はない。