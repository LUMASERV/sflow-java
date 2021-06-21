package com.lumaserv.sflow.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AddressType {

    IPV4(1, 4),
    IPV6(2, 16);

    final int value;
    final int length;

    public static AddressType fromValue(int value) {
        for(AddressType t : values()) {
            if(t.value == value)
                return t;
        }
        return null;
    }

}
