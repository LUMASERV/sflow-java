package com.lumaserv.sflow.record.counter;

import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class LAGCounterRecord implements CounterRecord {

    byte[] actorSystemId;
    byte[] partnerOperationalSystemId;
    int attachedAggregationId;
    boolean actorAdminState;
    boolean actorOperationalState;
    boolean partnerAdminState;
    boolean partnerOperationalState;

    public LAGCounterRecord(int enterprise, int type, byte[] data) {
        ByteBuffer bb = ByteBuffer.wrap(data);
        actorSystemId = new byte[6];
        bb.get(actorSystemId);
        partnerOperationalSystemId = new byte[6];
        bb.get(partnerOperationalSystemId);
        attachedAggregationId = bb.getInt();
        actorAdminState = bb.get() > 0;
        actorOperationalState = bb.get() > 0;
        partnerAdminState = bb.get() > 0;
        partnerOperationalState = bb.get() > 0;
    }

}
