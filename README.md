# sflow-java
sFlow parser and collector library for Java

## Usage
```java
SFlowCollector collector = new SFlowCollector(packet -> {
    for(Sample s : packet.getSamples()) {
        if(s instance FlowSample) {
            FlowSample flowSample = (FlowSample) s;
            // Do what you like
        }
    }
});
collector.join();
```

## Maven
```xml
<repository>
    <id>lumaserv</id>
    <url>https://maven.lumaserv.cloud</url>
</repository>
```
```xml
<dependency>
    <groupId>com.lumaserv</groupId>
    <artifactId>sflow-java</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```