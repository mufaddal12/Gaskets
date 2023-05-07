package com.fakhri.gaskets.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GasketType {
    RING_FACE("RF","Ring Face"), FULL_FACE("FF","Full Face");

    private String key;
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
