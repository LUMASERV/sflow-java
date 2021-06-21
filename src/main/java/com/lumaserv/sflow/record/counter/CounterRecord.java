package com.lumaserv.sflow.record.counter;

public interface CounterRecord {

    static CounterRecord from(int enterprise, int type, byte[] data) {
        if(enterprise == 0)
        switch (type) {
            case 1:
                return new GenericInterfaceCounterRecord(enterprise, type, data);
            case 2:
                return new EthernetInterfaceCounterRecord(enterprise, type, data);
            case 7:
                return new LAGCounterRecord(enterprise, type, data);
            case 2007:
                return new HostTCPIPCounterRecord(enterprise, type, data);
        }
        return new UnknownCounterRecord(enterprise, type, data);
    }

}
