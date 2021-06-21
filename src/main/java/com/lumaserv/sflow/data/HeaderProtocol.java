package com.lumaserv.sflow.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HeaderProtocol {

    ETHERNET(1),
    TOKENBUS(2),
    TOKENRING(3),
    FDDI(4),
    FRAME_RELAY(5),
    X25(6),
    PPP(7),
    SMDS(8),
    AAL5(9),
    AAL5_IP(10),
    IPV4(11),
    IPV6(12),
    MPLS(13);

    final int value;

    public static HeaderProtocol fromValue(int value) {
        for(HeaderProtocol p : values()) {
            if(p.value == value)
                return p;
        }
        return null;
    }

}
