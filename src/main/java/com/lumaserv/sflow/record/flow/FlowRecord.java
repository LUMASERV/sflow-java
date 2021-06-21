package com.lumaserv.sflow.record.flow;

public interface FlowRecord {

    static FlowRecord from(int enterprise, int type, byte[] data) {
        if(enterprise == 0)
        switch (type) {
            case 1:
                return new RawPacketHeaderRecord(enterprise, type, data);
            case 1001:
                return new ExtendedSwitchDataRecord(enterprise, type, data);
            case 1002:
                return new ExtendedRouterDataRecord(enterprise, type, data);
        }
        return new UnknownFlowRecord(enterprise, type, data);
    }

}
