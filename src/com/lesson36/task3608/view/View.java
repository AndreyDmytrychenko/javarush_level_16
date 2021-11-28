package com.lesson36.task3608.view;

import com.lesson36.task3608.controller.Controller;
import com.lesson36.task3608.model.ModelData;

public interface View {

    void refresh(ModelData modelData);

    void setController(Controller controller);

}
