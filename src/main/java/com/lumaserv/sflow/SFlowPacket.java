package com.lumaserv.sflow;

import com.lumaserv.sflow.data.AddressType;
import com.lumaserv.sflow.sample.Sample;
import lombok.Getter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SFlowPacket {

    int version;
    AddressType agentAddressType;
    byte[] agentAddress;
    int subAgentId;
    int sequenceNumber;
    int systemUptime;
    List<Sample> samples = new ArrayList<>();

    public String getAgentAddressAsString() {
        try {
            return InetAddress.getByAddress(agentAddress).getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        }
    }

    public SFlowPacket(byte[] packet) {
        ByteBuffer bb = ByteBuffer.wrap(packet);
        version = bb.getInt();
        agentAddressType = AddressType.fromValue(bb.getInt());
        agentAddress = new byte[agentAddressType.getLength()];
        bb.get(agentAddress);
        subAgentId = bb.getInt();
        sequenceNumber = bb.getInt();
        systemUptime = bb.getInt();
        int numSamples = bb.getInt();
        for(int i=0; i<numSamples; i++) {
            int sampleEnterprise = bb.getInt();
            int sampleType = sampleEnterprise & 0xFFF;
            sampleEnterprise &= 0xFFFFF000;
            byte[] sampleData = new byte[bb.getInt()];
            bb.get(sampleData);
            samples.add(Sample.from(sampleEnterprise, sampleType, sampleData));
        }
    }

}
