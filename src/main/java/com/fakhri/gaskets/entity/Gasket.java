package com.fakhri.gaskets.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class Gasket {
    private String gasketClass;
    private String size;
    private GasketType type;
    private double innerDiameter;
    private double outerDiameter;

    public static Object[] getParametersInOrder(Gasket gasket) {
        return new Object[] {
                gasket.getGasketClass(),
                gasket.getSize(),
                gasket.getType().getKey(),
                gasket.getInnerDiameter(),
                gasket.getOuterDiameter()
        };
    }
}
