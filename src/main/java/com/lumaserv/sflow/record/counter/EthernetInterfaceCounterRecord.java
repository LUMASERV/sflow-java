package com.lumaserv.sflow.record.counter;

import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class EthernetInterfaceCounterRecord implements CounterRecord {

    int alignmentErrors;
    int fcsErrors;
    int singleCollisionFrames;
    int multipleCollisionFrames;
    int sqeTestErrors;
    int deferredTransmissions;
    int lateCollisions;
    int excessiveCollisions;
    int internalMacTransmitErrors;
    int carrierSenseErrors;
    int frameTooLongErrors;
    int internalMacReceiveErrors;
    int symbolErrors;

    public EthernetInterfaceCounterRecord(int enterprise, int type, byte[] data) {
        ByteBuffer bb = ByteBuffer.wrap(data);
        alignmentErrors = bb.getInt();
        fcsErrors = bb.getInt();
        singleCollisionFrames = bb.getInt();
        multipleCollisionFrames = bb.getInt();
        sqeTestErrors = bb.getInt();
        deferredTransmissions = bb.getInt();
        lateCollisions = bb.getInt();
        excessiveCollisions = bb.getInt();
        internalMacTransmitErrors = bb.getInt();
        carrierSenseErrors = bb.getInt();
        frameTooLongErrors = bb.getInt();
        internalMacReceiveErrors = bb.getInt();
        symbolErrors = bb.getInt();
    }

}
