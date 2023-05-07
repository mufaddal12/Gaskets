package com.fakhri.gaskets.views;

import com.fakhri.gaskets.controllers.Controller;

import java.util.List;

public interface DetailsView<T> {
    T getSelectedItem();
    void setSelectableItems(List<T> gaskets);
    void setDetailsViewController(Controller detailsViewController);
}
