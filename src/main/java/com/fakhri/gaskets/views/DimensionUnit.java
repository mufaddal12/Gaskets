package com.fakhri.gaskets.views;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DimensionUnit {
    MM("mm", "Millimeter", 1), CM("cm","Centimeter", 10), M("m", "Meter", 1000);

    private String key;
    private String name;
    private double factor; // Corresponds to millimeter

    @Override
    public String toString() {
        return this.name;
    }
}
