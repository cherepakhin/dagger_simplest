### REST service project with Dagger (Dependeny Injection library).

REST - jersey

[[run_mvn_exec.sh](run_mvn_exec.sh)
````shell
mvn exec:java
````

[run_jar.sh](./run_jar.sh)

````shell
./run.sh

=========================================
Hello World
````

### Package executable jar

[package.sh](package.sh)

````shell
mvn clean package
````

### Run Jar

Java 11

````shell
java -jar target/dagger-simplest-1-jar-with-dependencies.jar
````

[./run_jar.sh](./run_jar.sh)

### Links:

[https://v.perm.ru/index.php/component/content/article/dagger?catid=15](https://v.perm.ru/index.php/component/content/article/dagger?catid=15)<br/>
[https://dagger.dev/dev-guide/](https://dagger.dev/dev-guide/)<br/>
[https://www.baeldung.com/dagger-2](https://www.baeldung.com/dagger-2)
