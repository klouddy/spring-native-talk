## Hello World Example

Pure java application to experiment with `native-image` tool.

#### Build and execute as executable JAR

`mvn clean package`

`java -jar target/pure-java-example.jar`

**With Timing:** `time java -jar target/pure-java-example.jar`

```
> time java -jar target/pure-java-example.jar
Hello world!
java -jar target/pure-java-example.jar  0.10s user 0.04s system 64% cpu 0.209 total
```

### Build and execute as native executable

`mvn clean pacakge`

`native-iamge -jar target/pure-java-example.jar target/pure-java-native`

`./taget/pure-java-native`

**With Timing**: `time ./taget/pure-java-native`

```
> time ./target/pure-java-native
Hello world!
./target/pure-java-native  0.00s user 0.00s system 13% cpu 0.056 total
```