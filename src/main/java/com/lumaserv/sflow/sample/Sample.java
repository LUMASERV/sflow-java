package com.lumaserv.sflow.sample;

public interface Sample {

    static Sample from(int enterprise, int type, byte[] data) {
        if(enterprise == 0)
        switch (type) {
            case 1:
                return new FlowSample(enterprise, type, data);
            case 2:
                return new CounterSample(enterprise, type, data);
        }
        return new UnknownSample(enterprise, type, data);
    }

}
