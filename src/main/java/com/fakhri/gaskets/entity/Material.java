package com.fakhri.gaskets.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@Builder
public class Material {
    private String name;
    private double width;
    private double height;
}
