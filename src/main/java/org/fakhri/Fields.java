package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Fields {

    MATERIAL_NAME("material_name", "Material Name"),
    MATERIAL_DIMENSION("material_dimension", "Material Dimension"),
    GASKET_SIZE("gasket_size", "Gasket Size"),
    GASKET_CLASS("gasket_class", "Gasket Class"),
    GASKET_TYPE("gasket_type", "Gasket Type");

    private String key, value;
}
