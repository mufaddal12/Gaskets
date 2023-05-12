package com.fakhri.gaskets.controllers;

import com.fakhri.gaskets.dao.GasketDao;
import com.fakhri.gaskets.entity.GasketType;
import com.fakhri.gaskets.views.DimensionUnit;
import com.fakhri.gaskets.views.forms.GasketDetailsView;

import java.awt.event.ActionListener;

public class GasketViewController implements Controller {
    private GasketDetailsView gasketDetailsView;
    private GasketDao gasketDao;

    public GasketViewController(GasketDetailsView gasketDetailsView) {
        this(gasketDetailsView, GasketDao.getInstance());
    }

    public GasketViewController(GasketDetailsView gasketDetailsView, GasketDao gasketDao) {
        this.gasketDetailsView = gasketDetailsView;
        this.gasketDao = gasketDao;
    }

    @Override
    public void addDataAndListeners() {
        gasketDetailsView.setGasketClasses(gasketDao.getAllClasses());
        gasketDetailsView.setGasketTypes(GasketType.values());

        String gasketClass = gasketDetailsView.getGasketClass();
        GasketType gasketType = gasketDetailsView.getGasketType();
        gasketDetailsView.setGaskets(gasketDao.getAllByClassAndType(gasketClass, gasketType));

        gasketDetailsView.updateUnit();

        gasketDetailsView.setActionListener(getActionListener());
    }

    private ActionListener getActionListener() {
        return e -> {
            String gasketClass1 = gasketDetailsView.getGasketClass();
            GasketType gasketType1 = gasketDetailsView.getGasketType();

            gasketDetailsView.setGaskets(gasketDao.getAllByClassAndType(gasketClass1, gasketType1));
        };
    }

}
