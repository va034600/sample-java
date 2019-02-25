
# sample-java-swagger-codegen

```
独自ライブラリのプロジェクトを生成
$ java -jar /usr/local/Cellar/swagger-codegen/3.0.4/libexec/swagger-codegen-cli.jar meta -o output/myLibrary -n myClientCodegen -p com.my.company.codegen

$ cd output/myLibrary/

$ mvn package

$ cd ../../

クライアント生成
$ java -cp output/myLibrary/target/myClientCodegen-swagger-codegen-1.0.0.jar:/usr/local/Cellar/swagger-codegen/3.0.4/libexec/swagger-codegen-cli.jar io.swagger.codegen.v3.cli.SwaggerCodegen generate -l myClientCodegen -i http://petstore.swagger.io/v2/swagger.json -o myClient
```
