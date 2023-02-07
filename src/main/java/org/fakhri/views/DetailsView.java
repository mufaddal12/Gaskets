package org.fakhri.views;

import org.fakhri.controllers.Controller;

import java.util.List;

public interface DetailsView<T> {
    T getSelectedItem();
    void setSelectableItems(List<T> gaskets);
    void setController(Controller controller);
}
