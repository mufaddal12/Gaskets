package com.fakhri.gaskets.dao.impl;

import java.io.IOException;
import java.util.List;

public class JdbcMaterialDaoTest {

    public static void main(String args[]) throws IOException {
        JdbcMaterialDao dao = new JdbcMaterialDao();
        List strings = dao.getAllUniqueMaterials();
        System.out.println(strings);
        List materials = dao.getMaterialsByName("Something");
        System.out.println(materials);
    }
}
