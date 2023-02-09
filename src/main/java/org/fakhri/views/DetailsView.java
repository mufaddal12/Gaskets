package org.fakhri.views;

import java.util.List;

public interface DetailsView<T> {
    T getSelectedItem();
    void setSelectableItems(List<T> gaskets);
    void setControllers();
}
