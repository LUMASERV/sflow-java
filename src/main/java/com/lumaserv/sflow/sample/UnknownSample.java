package com.lumaserv.sflow.sample;

import lombok.Getter;

@Getter
public class UnknownSample implements Sample {

    int enterprise;
    int type;
    byte[] data;

    public UnknownSample(int enterprise, int type, byte[] data) {
        this.enterprise = enterprise;
        this.type = type;
        this.data = data;
    }

}
