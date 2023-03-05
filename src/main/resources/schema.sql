CREATE SCHEMA IF NOT EXISTS GASKETSDB;

USE GASKETSDB;

CREATE TABLE IF NOT EXISTS MATERIAL (
    material_name varchar(128),
    width float(2),
    height float(2)
);

CREATE TABLE IF NOT EXISTS GASKETS (
    gasket_class varchar(128),
    gasket_size varchar(64),
    gasket_type varchar(64),
    inner_diameter float(2),
    outer_diameter float(2)
);