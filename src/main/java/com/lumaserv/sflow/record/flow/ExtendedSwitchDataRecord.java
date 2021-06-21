package com.lumaserv.sflow.record.flow;

import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class ExtendedSwitchDataRecord implements FlowRecord {

    int incomingVlan;
    int incomingPriority;
    int outgoingVlan;
    int outgoingPriority;

    public ExtendedSwitchDataRecord(int enterprise, int format, byte[] record) {
        ByteBuffer bb = ByteBuffer.wrap(record);
        incomingVlan = bb.getInt();
        incomingPriority = bb.getInt();
        outgoingVlan = bb.getInt();
        outgoingPriority = bb.getInt();
    }

}
