package com.lumaserv.sflow.record.counter;

import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class HostTCPIPCounterRecord implements CounterRecord {

    public HostTCPIPCounterRecord(int enterprise, int type, byte[] data) {
        ByteBuffer bb = ByteBuffer.wrap(data);
    }

}
