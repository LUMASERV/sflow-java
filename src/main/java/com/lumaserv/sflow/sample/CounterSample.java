package com.lumaserv.sflow.sample;

import com.lumaserv.sflow.record.counter.CounterRecord;
import com.lumaserv.sflow.record.flow.FlowRecord;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class CounterSample implements Sample {

    int sequenceNumber;
    int sourceIdClass;
    int sourceId;
    List<CounterRecord> records = new ArrayList<>();

    public CounterSample(int enterprise, int type, byte[] data) {
        ByteBuffer bb = ByteBuffer.wrap(data);
        sequenceNumber = bb.getInt();
        sourceIdClass = bb.getInt();
        sourceId = sourceIdClass & 0xFFFFFF;
        sourceIdClass &= 0xFF000000;
        int recordCount = bb.getInt();
        for(int i=0; i<recordCount; i++) {
            int recordEnterprise = bb.getInt();
            int recordType = recordEnterprise & 0xFFF;
            recordEnterprise &= 0xFFFFF000;
            byte[] recordData = new byte[bb.getInt()];
            bb.get(recordData);
            records.add(CounterRecord.from(recordEnterprise, recordType, recordData));
        }
    }

}
