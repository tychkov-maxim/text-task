package com.epam.tm.textTask.entity;

import java.util.List;

public interface TextComponent {

    String getValue();
    void getAllUnits(List<TextComponent> unitText, Class clazz);
}
