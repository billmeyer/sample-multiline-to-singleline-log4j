# sample-multiline-to-singleline-log4j

## Background

This sample app demonstrates using Log4J to convert multiline log entries (e.g., Exception stack traces) to
single line entries for logging in a machine-readable format.

## Configuration

To do this, the `./src/main/resources/log4j2.xml` file has a **Console** appender defined as:

```XML
    <Appenders>
        <Console name="LogToConsole" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n %throwable{separator(|)}"/>
        </Console>
    </Appenders>
```

The `%throwable{separator(|)}` entry in the `<PatternLayout>` element converts line feeds to pipe characters `|` for `throwable` types.

## Execution

### Before adding `%throwable{separator(|)}` to `log4j2.xml`

```
$ gradle run
```

```
> Task :run
12:09:44.329 [main] DEBUG com.mezmo.samples.Main - Hello world!
 12:09:44.330 [main] ERROR com.mezmo.samples.Main - Exception occurred
 java.lang.Exception: This is the exception
	at com.mezmo.samples.Main.doSomethingElse(Main.java:14) ~[main/:?]
	at com.mezmo.samples.Main.doSomething(Main.java:10) ~[main/:?]
	at com.mezmo.samples.Main.main(Main.java:21) ~[main/:?]
```

### After adding `%throwable{separator(|)}` to `log4j2.xml`

```
$ gradle run
```

```
> Task :run
12:09:13.494 [main] DEBUG com.mezmo.samples.Main - Hello world!
12:09:13.496 [main] ERROR com.mezmo.samples.Main - Exception occurred
java.lang.Exception: This is the exception|	at com.mezmo.samples.Main.doSomethingElse(Main.java:14)|	at com.mezmo.samples.Main.doSomething(Main.java:10)|	at com.mezmo.samples.Main.main(Main.java:21)
```

