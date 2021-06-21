package com.lumaserv.sflow.record.flow;

import com.lumaserv.sflow.data.HeaderProtocol;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class RawPacketHeaderRecord implements FlowRecord {

    HeaderProtocol headerProtocol;
    int frameLength;
    int payloadRemoved;
    int originalPacketLength;

    public RawPacketHeaderRecord(int enterprise, int format, byte[] record) {
        ByteBuffer bb = ByteBuffer.wrap(record);
        headerProtocol = HeaderProtocol.fromValue(bb.getInt());
        frameLength = bb.getInt();
        payloadRemoved = bb.getInt();
        originalPacketLength = bb.getInt();
        // TODO parse headers
    }

}
