package com.lumaserv.sflow.record.counter;

import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class GenericInterfaceCounterRecord implements CounterRecord {

    int interfaceIndex;
    int interfaceType;
    long interfaceSpeed;
    int interfaceDirection;
    boolean adminStatus;
    boolean operationalStatus;
    long inputBytes;
    int inputPackets;
    int inputMulticastPackets;
    int inputBroadcastPackets;
    int inputDiscardedPackets;
    int inputErrors;
    int inputUnknownProtocolPackets;
    long outputBytes;
    int outputPackets;
    int outputMulticastPackets;
    int outputBroadcastPackets;
    int outputDiscardedPackets;
    int outputErrors;
    int promiscuousMode;

    public GenericInterfaceCounterRecord(int enterprise, int type, byte[] data) {
        ByteBuffer bb = ByteBuffer.wrap(data);
        interfaceIndex = bb.getInt();
        interfaceType = bb.getInt();
        interfaceSpeed = bb.getLong();
        interfaceDirection = bb.getInt();
        int status = bb.getInt();
        adminStatus = (status & 0xb01) > 0;
        operationalStatus = (status & 0xb10) > 0;
        inputBytes = bb.getLong();
        inputPackets = bb.getInt();
        inputMulticastPackets = bb.getInt();
        inputBroadcastPackets = bb.getInt();
        inputDiscardedPackets = bb.getInt();
        inputErrors = bb.getInt();
        inputUnknownProtocolPackets = bb.getInt();
        outputBytes = bb.getLong();
        outputPackets = bb.getInt();
        outputMulticastPackets = bb.getInt();
        outputBroadcastPackets = bb.getInt();
        outputDiscardedPackets = bb.getInt();
        outputErrors = bb.getInt();
        promiscuousMode = bb.getInt();
    }

}
