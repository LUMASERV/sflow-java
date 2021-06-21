package com.lumaserv.sflow.record.counter;

import com.lumaserv.sflow.record.flow.FlowRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UnknownCounterRecord implements CounterRecord {

    int enterprise;
    int format;
    byte[] data;

}
