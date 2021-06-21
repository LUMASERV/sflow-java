package com.lumaserv.sflow.record.flow;

import com.lumaserv.sflow.data.AddressType;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class ExtendedRouterDataRecord implements FlowRecord {

    AddressType nextHopAddressType;
    byte[] nextHopAddress;
    int nextHopSourceMask;
    int nextHopDestinationMask;

    public ExtendedRouterDataRecord(int enterprise, int format, byte[] record) {
        ByteBuffer bb = ByteBuffer.wrap(record);
        nextHopAddressType = AddressType.fromValue(bb.getInt());
        nextHopAddress = new byte[nextHopAddressType.getLength()];
        bb.get(nextHopAddress);
        nextHopSourceMask = bb.getInt();
        nextHopDestinationMask = bb.getInt();
    }

}
