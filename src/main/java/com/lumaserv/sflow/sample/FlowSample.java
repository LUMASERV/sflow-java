package com.lumaserv.sflow.sample;

import com.lumaserv.sflow.record.flow.FlowRecord;
import lombok.Getter;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@Getter
public class FlowSample implements Sample {

    int sequenceNumber;
    int sourceIdClass;
    int sourceId;
    int samplingRate;
    int samplePool;
    int droppedPackets;
    int inputInterface;
    int outputInterface;
    List<FlowRecord> records = new ArrayList<>();

    public FlowSample(int enterprise, int type, byte[] data) {
        ByteBuffer bb = ByteBuffer.wrap(data);
        sequenceNumber = bb.getInt();
        sourceIdClass = bb.getInt();
        sourceId = sourceIdClass & 0xFFFFFF;
        sourceIdClass &= 0xFF000000;
        samplingRate = bb.getInt();
        samplePool = bb.getInt();
        droppedPackets = bb.getInt();
        inputInterface = bb.getInt();
        outputInterface = bb.getInt();
        int recordCount = bb.getInt();
        for(int i=0; i<recordCount; i++) {
            int recordEnterprise = bb.getInt();
            int recordType = recordEnterprise & 0xFFF;
            recordEnterprise &= 0xFFFFF000;
            byte[] recordData = new byte[bb.getInt()];
            bb.get(recordData);
            records.add(FlowRecord.from(recordEnterprise, recordType, recordData));
        }
    }

}
