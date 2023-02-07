package org.fakhri.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class Gasket {
    private String gClass;
    private String size;
    private GasketType type;
    private float innerDiameter, outerDiameter;
}
