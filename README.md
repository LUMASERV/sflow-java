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