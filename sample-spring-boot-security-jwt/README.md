# コピー元
JWTを利用したSpringアプリのAPI認証
https://qiita.com/nyasba/items/f9b1b6be5540743f8bac

```
$ curl -v -X POST -d "{ \"loginId\" : \"nyasba\", \"pass\" : \"password\"}" -H "accept: application/json" -H "Content-Type: application/json" "http://localhost:8080/user/login"
```

```
$ curl -X GET -H "Authorization: Bearer XXXX" "http://localhost:8080/private"
```
