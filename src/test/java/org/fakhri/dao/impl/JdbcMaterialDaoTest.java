package org.fakhri.dao.impl;

import java.util.List;

public class JdbcMaterialDaoTest {

    public static void main(String args[]) {
        JdbcMaterialDao dao = new JdbcMaterialDao();
        List strings = dao.getAllUniqueMaterials();
        System.out.println(strings);
        List materials = dao.getMaterialsByName("Something");
        System.out.println(materials);
    }
}
