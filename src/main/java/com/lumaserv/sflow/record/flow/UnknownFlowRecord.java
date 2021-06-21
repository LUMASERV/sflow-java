package com.lumaserv.sflow.record.flow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UnknownFlowRecord implements FlowRecord {

    int enterprise;
    int format;
    byte[] data;

}
