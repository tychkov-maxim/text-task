package com.epam.tm.textTask.entity;

import java.util.List;

public interface Textable {

    String getValue();
    void getAllUnits(List<Textable> unitText,Class clazz);
}
